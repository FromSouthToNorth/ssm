<template>
  <div class="home">
    <el-row :gutter="10">
      <el-col :span="8">
        <el-input
            placeholder="请输入员工名称"
            v-model="queryParams.name"
            clearable
        ></el-input>
      </el-col>
      <el-col :span="4">
        <el-button type="primary" @click="search" icon="el-icon-search">搜索</el-button>
      </el-col>
      <el-col :span="4">
        <el-button type="success" @click="addStaff">添加员工</el-button>
      </el-col>
    </el-row>
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
          width="220px"
      >
        <template slot-scope="scope">
          <el-button size="min" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">修改</el-button>
          <el-button size="min" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)">删除</el-button>
          <el-button size="min" type="text" icon="el-icon-view" @click="handleCheck(scope.row)">查看</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        v-show="total > 0"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-sizes="pageSizes"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
    <!-- 添加或修改员工对话框 -->
    <el-dialog :title="title" :visible.sync="dialogFormVisible" width="600px" append-to-body>
      <el-form :model="form">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="姓名" :label-width="formLabelWidth">
              <el-input v-model="form.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="年龄" :label-width="formLabelWidth">
              <el-input v-model="form.age" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别" :label-width="formLabelWidth">
              <el-select v-model="form.sex" placeholder="请选择">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="所在省" :label-width="formLabelWidth">
              <el-select v-model="form.provinceId" placeholder="请选择">

              </el-select>
            </el-form-item>
            <el-form-item label="所在市" :label-width="formLabelWidth">
              <el-select v-model="form.cityId" placeholder="请选择">

              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-upload
                class="avatar-uploader"
                action="https://jsonplaceholder.typicode.com/posts/"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { staffList } from "@/api/staff/staffList";

export default {
  name: "staff",
  data() {
    return {
      staffs: [  ],
      loading: true,
      total: 0,
      pageSizes: [2, 6, 8],
      queryParams: {
        pageSize: 2,
        pageNum: 1,
        name: '',
      },
      form: {  },
      title: '',
      formLabelWidth: '80px',
      dialogFormVisible: false,
      imageUrl: '',
    }
  },
  created() {
    this.getStaffList();
  },
  methods: {
    search() {
      this.getStaffList();
    },
    /** 查询员工列表 */
    getStaffList() {
      this.loading = true;
      staffList(this.queryParams).then(response => {
        this.staffs = response.rows;
        this.total = response.total;
        this.loading = false;
      })
    },
    /** 添加员工 */
    addStaff() {
      this.title = '添加员工'
      this.dialogFormVisible = true
    },
    /** 编辑 */
    handleUpdate(row) {
      this.title = '编辑员工'
      this.dialogFormVisible = true;
      console.log(row)
    },
    /** 删除 */
    handleDelete(row) {
      console.log(row)
    },
    /** 查看 */
    handleCheck(row) {
      console.log(row)
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
    handleAvatarSuccess() {

    },
    beforeAvatarUpload() {

    }
  }
}
</script>

<style>
.home {
  margin-top: 40px;
  margin-left: auto;
  margin-right: auto;
  width: 880px;
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