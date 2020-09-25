<template>
  <div>
    <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
      <el-radio-button :label="false">展开</el-radio-button>
      <el-radio-button :label="true">收起</el-radio-button>
    </el-radio-group>
    <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
      <el-menu-item index="1">
        <i class="el-icon-menu"></i>
        <span slot="title">员工列表</span>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-setting"></i>
        <span slot="title">服务器监控</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import Staff from "@/views/staff/index";
export default {
  name: "NavMenu",
  components: {Staff},
  data() {
    return {
      isCollapse: true,
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>

</style>