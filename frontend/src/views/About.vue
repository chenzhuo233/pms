<template>
  <div class="about">
    <h2>Instructions</h2>
    <el-collapse v-model="activeNames" @change="handleChange" style="width:300px">
      <el-collapse-item title="功能 Features" name="1">
        <div>点击增加新员工，填写员工信息，提交即可</div>
        <div>查询员工，输入员工号即可查询该员工的所有信息</div>
        <div>查询所有员工，可以获得库内所有员工的信息</div>
        <div>更改员工信息，输入要更改的员工号，然后更改员工的信息后提交即可</div>
        <div>人事管理，可以添加人事变动信息，填写表单然后提交即可</div>
        <div>人事查询，可以看到全部的人事变动信息</div>
      </el-collapse-item>
      <el-collapse-item title="登录 Login" name="2">
        <div>不正确登录的话无法进行其他操作哦</div>
      </el-collapse-item>
      <el-collapse-item title="效率 Efficiency" name="3">
        <div>简化流程：设计简洁直观的操作流程；</div>
        <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
        <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
      </el-collapse-item>
      <el-collapse-item title="可控 Controllability" name="4">
        <div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
        <div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeNames: []
    };
  },
  methods: {
    handleChange(val) {
      console.log(val);
    }
  }
};
</script>
