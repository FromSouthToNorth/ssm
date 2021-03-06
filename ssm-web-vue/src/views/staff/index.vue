<template>
  <div class="home">
    <!-- 搜索框 -->
    <el-row :gutter="10">
      <el-col :span="8">
        <el-input
            placeholder="请输入员工名称"
            v-model="queryParams.name"
            clearable
        ></el-input>
      </el-col>
      <el-col :span="4">
        <el-button type="primary" @click="search" icon="el-icon-search" size="small">搜索</el-button>
      </el-col>
      <el-col :span="4">
        <el-button type="success" @click="addStaff" size="small">添加员工</el-button>
      </el-col>
    </el-row>
    <!-- 员工列表 -->
    <el-table
        :data="staffs"
        v-loading="loading"
        style="width: 100%">
      <el-table-column
          prop="id"
          label="id">
      </el-table-column>
      <el-table-column
          prop="name"
          label="姓名">
      </el-table-column>
      <el-table-column
          prop="age"
          label="年龄">
      </el-table-column>
      <el-table-column
          prop="sex"
          label="性别">
      </el-table-column>
      <el-table-column
          prop="provinceName"
          label="所在省">
      </el-table-column>
      <el-table-column
          prop="cityName"
          label="所在市">
      </el-table-column>
      <el-table-column
          label="操作"
          align="center"
          width="220px">
        <template slot-scope="scope">
          <el-button size="min" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">修改</el-button>
          <el-button size="min" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)">删除</el-button>
          <el-button size="min" type="text" icon="el-icon-upload" @click="handleUpdateAvatar(scope.row)">上传头像</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
        v-show="total > 0"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-sizes="pageSizes"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
    <!-- 添加或修改员工对话框 -->
    <el-dialog :title="title" :visible.sync="dialogFormVisible" width="320px" append-to-body>
      <el-form :model="form" ref="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model.number="form.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所在省" prop="provinceId">
          <el-select v-model="form.provinceId" placeholder="请选择" @change="getProvince">
            <el-option
                v-for="item in addressOptions"
                :key="item.province.id"
                :label="item.province.name"
                :value="item.province.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所在市" prop="cityId">
          <el-select v-model="form.cityId" placeholder="请选择">
            <el-option
                v-for="item in cityOptions"
                :key="item.id"
                :label="item.name"
                :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="submitForm">确 定</el-button>
      </div>
    </el-dialog>
    <el-dialog title="上传头像" :visible.sync="upload.open" width="220px">
      <el-upload
          class="avatar-uploader"
          :action="upload.url"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
          :auto-upload="false">
        <img v-if="imageUrl" :src="imageUrl" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button @click="upload.open = false">取 消</el-button>
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
      </div>
    </el-dialog>
    <server></server>
  </div>
</template>

<script>
/** 导入员工的 api */
import {
  staff,
  addStaff,
  getStaff,
  updateStaff,
  deleteStaff,
} from "@/api/system/staff";

/** 导入地址的 api */
import { listAddress } from "@/api/system/address";
import Server from "@/views/server/index";


export default {
  name: "staff",
  components: {Server},
  data() {
    return {
      // 员工列表
      staffs: [  ],
      // 地址
      addressOptions: [  ],
      // 市级地址
      cityOptions: [  ],
      // 加载中遮罩层
      loading: true,
      // 员工列表总数
      total: 0,
      // 分页页面大小
      pageSizes: [2, 6, 8],
      // 查询参数
      queryParams: {
        pageSize: 2,
        pageNum: 1,
        name: '',
      },
      // 表单参数
      form: {  },
      // 上传
      upload: {
        open: false,
        // 是否禁用
        isUploading: false,
        url: "http://localhost:8888/staff/updateAvatar",
      },
      // 弹出层标题
      title: '',
      // 编辑员工对话框
      dialogFormVisible: false,
      // 上传员工头像对话框
      dialogUpdateAvatarVisible: false,
      // 头像 URL
      imageUrl: '',
      // 表单验证
      rules: {
        name: [
          { required: true, message: "名称不能为空", trigger: "blur" },
        ],
        age: [
          { required: true, message: "年龄不能为空", trigger: 'blur' },
          {
            type: 'number',
            message: "请输入正确的年龄",
            trigger: 'blur',
          }
        ],
        sex: [
          { required: true, message: "性别不能为空", trigger: "blur" },
        ],
        provinceId: [
          { required: true, message: "所在省不能为空", trigger: "blur" },
        ],
        cityId: [
          { required: true, message: "所在市不能为空", trigger: "blur" },
        ]
      },
      server: [  ],
    }
  },
  created() {
    this.getStaffList();
    this.getAddressList();
  },
  methods: {
    search() {
      this.getStaffList();
    },
    /** 查询员工列表 */
    getStaffList() {
      this.loading = true;
      staff(this.queryParams).then(response => {
        this.staffs = response.rows;
        this.total = response.total;
        this.loading = false;
      })
    },
    getProvince(value) {
      for (let i =0; i < this.addressOptions.length; i++) {
        if (this.addressOptions[i].province.id === value) {
          this.cityOptions = this.addressOptions[i].cities
        }
      }
     },
    getAddressList() {
      listAddress().then((response) => {
        this.addressOptions = response.data;
      })
    },
    /** 添加员工按钮 */
    addStaff() {
      this.reset();
      this.title = '添加员工'
      this.dialogFormVisible = true
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getAddressList();
      const staffId = row.id;
      getStaff(staffId).then((response) => {
        console.log(response.data);
        this.form = response.data;
        this.title = '编辑员工';
        this.getProvince(response.data.provinceId);
        console.log(this.form.id);
        this.dialogFormVisible = true;
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const staffId = row.id;
      this.$confirm(
        '是否确认删除用户编号为"' + staffId + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      ).then(function () {
        return deleteStaff(staffId);
      }).then(() => {
        this.getStaffList();
        this.msgSuccess("删除成功");
      }).catch(function () {});
    },
    /** 上传头像按钮操作 */
    handleUpdateAvatar(row) {
      console.log(row)
      this.upload.open = true;
    },
    /** 每页大小 */
    handleSizeChange(val) {
      this.queryParams.pageSize = val;
      this.getStaffList();
    },
    /** 页面跳转 */
    handleCurrentChange(val) {
      this.queryParams.pageNum = val;
      this.getStaffList();
    },
    /** 取消按钮 */
    cancel() {
      this.dialogFormVisible = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form ={
        id: undefined,
        name: undefined,
        age: undefined,
        sex: undefined,
        provinceId: undefined,
        cityId: undefined,
      }
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id !== undefined) {
            updateStaff(this.form).then((response) => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.dialogFormVisible = false;
                this.getStaffList();
              }
            })
          } else {
            addStaff(this.form).then((response) => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.dialogFormVisible = false;
                this.getStaffList();
              }
            });
          }
        }
      })
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isType = file.type === 'image/jpeg' || 'image/jpg' || 'image/webp' || 'image/png';
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isType) {
        this.$message.error("上传头像图片只包含 JPG,PNG,WEBP,JPEG 格式！");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片不能超过 2MB");
      }
      return isType && isLt2M;
    },
    submitFileForm() {
      this.$refs.cropper.getCropBlob(data => {
        let formData = new FormData();
        formData.append("avatarfile", data);
        console.log(formData);
      })
    },
  }
}
</script>

<style>
.home {
  margin-top: 40px;
  margin-left: auto;
  margin-right: auto;
  width: 1124px;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.el-upload .avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
