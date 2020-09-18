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
    <el-dialog :title="title" :visible.sync="dialogFormVisible" append-to-body>
      <el-form :model="form">
        <el-form-item label="活动名称" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="活动区域" :label-width="formLabelWidth">
          <el-select v-model="form.region" placeholder="请选择活动区域">
            <el-option label="区域一" value="shanghai"></el-option>
            <el-option label="区域二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
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
      formLabelWidth: '120px',
      dialogFormVisible: false,
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
  }
}
</script>

<style scoped>
.home {
  margin-top: 40px;
  margin-left: auto;
  margin-right: auto;
  width: 880px;
}
</style>