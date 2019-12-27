<template>
  <el-table :data="personlist" style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="员工号">
            <span>{{ props.row.id }}</span>
          </el-form-item>
          <el-form-item label="密码">
            <span>{{ props.row.passwd }}</span>
          </el-form-item>
          <el-form-item label="权限">
            <span>{{ props.row.authority }}</span>
          </el-form-item>
          <el-form-item label="姓名">
            <span>{{ props.row.name }}</span>
          </el-form-item>
          <el-form-item label="性别">
            <span>{{ props.row.sex }}</span>
          </el-form-item>
          <el-form-item label="生日">
            <span>{{ props.row.birthday }}</span>
          </el-form-item>
          <el-form-item label="部门">
            <span>{{ props.row.department }}</span>
          </el-form-item>
          <el-form-item label="工作">
            <span>{{ props.row.job }}</span>
          </el-form-item>
          <el-form-item label="学历">
            <span>{{ props.row.eduLevel }}</span>
          </el-form-item>
          <el-form-item label="专业特长">
            <span>{{ props.row.spcialty }}</span>
          </el-form-item>
          <el-form-item label="地址">
            <span>{{ props.row.address }}</span>
          </el-form-item>
          <el-form-item label="电话">
            <span>{{ props.row.tel }}</span>
          </el-form-item>
          <el-form-item label="邮箱">
            <span>{{ props.row.email }}</span>
          </el-form-item>
          <el-form-item label="在职状态">
            <span>{{ props.row.state}}</span>
          </el-form-item>
          <el-form-item label="备注">
            <span>{{ props.row.remark }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column label="员工号" prop="id"></el-table-column>
    <el-table-column label="姓名" prop="name"></el-table-column> 
  <el-table-column label=''><el-button type="primary" @click="getmsg">刷新</el-button></el-table-column>
  </el-table>
  
</template>

<script>
import request from "../axios";
export default {
  data() {
    return {
      personlist: [
        {
          id: 0,
          passwd: "",
          authority: "",
          name: "",
          sex: "",
          birthday: "",
          department: 0,
          job: 0,
          eduLevel: 0,
          spcialty: "",
          address: "",
          tel: "",
          email: "",
          state: true,
          remark: ""
        }
      ]
    };
  },
  methods: {
    getmsg() {
        this.personlist=[]
        let that = this;
        request({
            url:'persons/'+sessionStorage.getItem('loginInfo'),
            method:'GET'
        }).then(response=>{
            let person = response.data;
            that.personlist.push(person);
        })
    }
  }
};
</script>

<style>
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>