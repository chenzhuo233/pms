<template>
  <div class="header-div">
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
    >
      <el-menu-item index="1">
        <router-link to="/home">主页</router-link>
      </el-menu-item>
    <el-menu-item index='2'>
        <router-link to="/">登录</router-link>
    </el-menu-item>
      <el-menu-item index="3">
        <router-link to="/about">关于</router-link>
      </el-menu-item>
      <el-header style="text-align: right; font-size: 12px; background-color: rgb(96, 200, 226);">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>人事管理系统</span>
      </el-header>
    </el-menu>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: "2"
    };
  },
  methods: {
    
  }
};
</script>

<style>

</style>