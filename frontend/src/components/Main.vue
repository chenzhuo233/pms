<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1']">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-menu"></i>操作
          </template>
          <el-menu-item-group>
            <template slot="title">员工管理</template>
            <el-menu-item index="1-1">
              <el-button type="text" @click="dialogFormVisible = true">新增员工</el-button>
            </el-menu-item>
            <el-menu-item index="1-2">
              <el-button type="text" @click="getonebtn">查找员工</el-button>
            </el-menu-item>
            <el-menu-item index="1-3" @click="getall">查询所有员工</el-menu-item>
            <el-menu-item index="1-4" @click="updatePerson">更改员工信息</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group>
            <template slot="title">部门工作</template>
            <el-menu-item index="1-1" @click="getDp">部门一览</el-menu-item>
            <el-menu-item index="1-2" @click="getJob">工作一览</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group>
            <template slot="title">人事管理</template>
            <el-menu-item index="1-1" @click="showPsnl =true">人事变动</el-menu-item>
            <el-menu-item index="1-2" @click="getPersonnel">人事记录</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-main>
        <!--新增员工弹出-->
        <el-dialog title="新增员工信息" :visible.sync="dialogFormVisible">
          <el-form :model="form" label-width="120px">
            <el-form-item
              label="姓名"
              label-width="52px"
              :rules="[
      { required: true, message: '姓名不能为空'}
    ]"
            >
              <el-input v-model="form.name" placeholder="请输入姓名" style="width:100px"></el-input>
            </el-form-item>
            <el-form-item label="性别">
              <el-radio-group v-model="form.sex">
                <el-radio label="男" value="男"></el-radio>
                <el-radio label="女" value="女"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="在职">
              <el-switch v-model="form.state"></el-switch>
            </el-form-item>
            <el-form-item label="部门编号" label-width="69px">
              <el-select v-model="form.department" placeholder="请选择部门">
                <el-option label="人事部-01" value="人事部"></el-option>
                <el-option label="研发部-02" value="研发部"></el-option>
                <el-option label="财务部-03" value="财务部"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item
              label="工作编号"
              label-width="69px">
              <el-select v-model="form.job" placeholder="请选择职务">
                <el-option label="人事-01" value=1></el-option>
                <el-option label="后端-02" value=2></el-option>
                <el-option label="前端-03" value=3></el-option>
                <el-option label="运营-04" value=4></el-option>
                <el-option label="运维-05" value=5></el-option>
                <el-option label="测试-06" value=6></el-option>
                <el-option label="财务-07" value=7></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="权限" label-width="50px">
              <el-select v-model="form.authority" placeholder="请选择权限">
                <el-option label="管理员" value="管理员"></el-option>
                <el-option label="员工" value="员工"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="学历" label-width="50px">
              <el-select v-model="form.eduLevel" placeholder="请选择学历">
                <el-option label="小学-01" value="1"></el-option>
                <el-option label="初中-02" value="2"></el-option>
                <el-option label="高中-03" value="3"></el-option>
                <el-option label="职高-04" value="4"></el-option>
                <el-option label="大本-05" value="5"></el-option>
                <el-option label="大专-06" value="6"></el-option>
                <el-option label="硕士-07" value="7"></el-option>
                <el-option label="博士-08" value="8"></el-option>
                <el-option label="博士后-09" value="9"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="密码" label-width="50px">
              <el-input type="password" v-model="form.passwd" style="width:200px"></el-input>
            </el-form-item>

            <el-form-item
              label="电话"
              label-width="50px"
              :rules="[{ type: 'number', message: '电话必须为数字值'}]"
            >
              <el-input v-model="form.tel" style="width:200px"></el-input>
            </el-form-item>
            <el-form-item
              label="邮箱"
              label-width="50px"
              :rules="[{ type: 'email', message: '邮箱不正确'}]"
            >
              <el-input v-model="form.email" style="width:200px"></el-input>
            </el-form-item>
            <el-form-item label="生日" label-width="50px">
              <el-col :span="11">
                <el-date-picker
                  type="date"
                  placeholder="选择日期"
                  value-format="yyyy-MM-dd"
                  v-model="form.birthday"
                  style="width: 100%;"
                ></el-date-picker>
              </el-col>
            </el-form-item>
            <el-form-item label="住址" label-width="50px">
              <el-input v-model="form.address"></el-input>
            </el-form-item>
            <el-form-item label="特长" label-width="50px">
              <el-input v-model="form.spcialty"></el-input>
            </el-form-item>
            <el-form-item label="备注" label-width="50px">
              <el-input v-model="form.remark"></el-input>
            </el-form-item>
          </el-form>

          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button :plain="true" type="primary" @click="addNewPerson">确 定</el-button>
          </div>
        </el-dialog>
        <!--新增员工弹出-->

        <!--查询单个员工信息-->
        <el-table v-show="showPerson" :data="oneperson">
          <el-table-column prop="id" label="员工号" width="140"></el-table-column>
          <el-table-column prop="passwd" label="密码" width="140"></el-table-column>
          <el-table-column prop="authority" label="权限" width="120"></el-table-column>
          <el-table-column prop="name" label="姓名" width="120"></el-table-column>
          <el-table-column prop="sex" label="性别" width="100"></el-table-column>
          <el-table-column prop="birthday" label="生日" width="140"></el-table-column>
          <el-table-column prop="department" label="部门" width="110"></el-table-column>
          <el-table-column prop="job" label="工作" width="120"></el-table-column>
          <el-table-column prop="eduLevel" label="学历" width="100"></el-table-column>
          <el-table-column prop="spcialty" label="特长" width="300"></el-table-column>
          <el-table-column prop="address" label="地址" width="300"></el-table-column>
          <el-table-column prop="tel" label="电话" width="200"></el-table-column>
          <el-table-column prop="email" label="邮箱" width="200"></el-table-column>
          <el-table-column prop="state" label="状态" width="110"></el-table-column>
          <el-table-column prop="remark" label="备注" width="400"></el-table-column>
        </el-table>
        <!--查询单个员工信息-->

        <!--全部员工列表-->
        <el-table v-show="showAll" v-loading.fullscreen.lock="fullscreenLoading" :data="persondata">
          <el-table-column prop="id" label="员工号" width="140"></el-table-column>
          <el-table-column prop="passwd" label="密码" width="140"></el-table-column>
          <el-table-column prop="authority" label="权限" width="120"></el-table-column>
          <el-table-column prop="name" label="姓名" width="120"></el-table-column>
          <el-table-column prop="sex" label="性别" width="100"></el-table-column>
          <el-table-column prop="birthday" label="生日" width="140"></el-table-column>
          <el-table-column prop="department" label="部门" width="110"></el-table-column>
          <el-table-column prop="job" label="工作" width="120"></el-table-column>
          <el-table-column prop="eduLevel" label="学历" width="100"></el-table-column>
          <el-table-column prop="spcialty" label="特长" width="300"></el-table-column>
          <el-table-column prop="address" label="地址" width="300"></el-table-column>
          <el-table-column prop="tel" label="电话" width="200"></el-table-column>
          <el-table-column prop="email" label="邮箱" width="200"></el-table-column>
          <el-table-column prop="state" label="状态" width="110"></el-table-column>
          <el-table-column prop="remark" label="备注" width="400"></el-table-column>
        </el-table>
        <!--全部员工列表-->

        <!--更新员工-->

        <el-form :model="updateform" label-width="100px" v-show="showUp">
          <el-form-item
            label="姓名"
            label-width="100px"
            :rules="[
      { required: true, message: '姓名不能为空'}
    ]"
          >
            <el-input v-model="updateform.name" placeholder="请输入姓名" style="width:100px"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio-group v-model="updateform.sex">
              <el-radio label="男" value="男"></el-radio>
              <el-radio label="女" value="女"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="在职">
            <el-switch v-model="updateform.state"></el-switch>
          </el-form-item>
          <el-form-item
            label="部门编号"
            label-width="100px"
            :rules="[{ type: 'number', message: '部门编号必须为数字值'}]"
          >
            <el-input v-model="updateform.department" style="width:100px"></el-input>
          </el-form-item>
          <el-form-item
            label="工作编号"
            label-width="100px"
            :rules="[{ type: 'number', message: '工作编号必须为数字值'}]"
          >
            <el-input v-model.number="updateform.job" style="width:100px"></el-input>
          </el-form-item>
          <el-form-item label="权限" label-width="100px">
            <el-select v-model="updateform.authority" placeholder="请选择权限">
              <el-option label="管理员" value="管理员"></el-option>
              <el-option label="员工" value="员工"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="学历" label-width="100px">
            <el-select v-model.number="updateform.eduLevel" placeholder="请选择学历">
              <el-option label="小学-01" value="1"></el-option>
              <el-option label="初中-02" value="2"></el-option>
              <el-option label="高中-03" value="3"></el-option>
              <el-option label="职高-04" value="4"></el-option>
              <el-option label="大本-05" value="5"></el-option>
              <el-option label="大专-06" value="6"></el-option>
              <el-option label="硕士-07" value="7"></el-option>
              <el-option label="博士-08" value="8"></el-option>
              <el-option label="博士后-09" value="9"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="密码" label-width="100px">
            <el-input type="password" v-model="updateform.passwd" style="width:200px"></el-input>
          </el-form-item>

          <el-form-item
            label="电话"
            label-width="100px"
            :rules="[{ type: 'number', message: '电话必须为数字值'}]"
          >
            <el-input v-model="updateform.tel" style="width:200px"></el-input>
          </el-form-item>
          <el-form-item
            label="邮箱"
            label-width="100px"
            :rules="[{ type: 'email', message: '邮箱不正确'}]"
          >
            <el-input v-model="updateform.email" style="width:200px"></el-input>
          </el-form-item>
          <el-form-item label="生日" label-width="100px">
            <el-col :span="12">
              <el-date-picker
                type="date"
                placeholder="选择日期"
                value-format="yyyy-MM-dd"
                v-model="updateform.birthday"
                style="width: 100%;"
              ></el-date-picker>
            </el-col>
          </el-form-item>
          <el-form-item label="住址" label-width="100px">
            <el-input v-model="updateform.address"></el-input>
          </el-form-item>
          <el-form-item label="特长" label-width="100px">
            <el-input v-model="updateform.spcialty"></el-input>
          </el-form-item>
          <el-form-item label="备注" label-width="100px">
            <el-input v-model="updateform.remark"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm(updateform)">更新</el-button>
            <el-button>重置</el-button>
          </el-form-item>
        </el-form>

        <!--人事变动-->
        <el-dialog title="人事变动信息" :visible.sync="showPsnl">
          <el-form :model="personnelform" label-width="120px">
            <el-form-item
              label="员工号"
              label-width="100px"
              :rules="[{ type: 'number', message: '员工号必须为数字值'}]"
            >
              <el-input
                v-model.number="personnelform.person"
                placeholder="请输入员工号"
                style="width:100px"
              ></el-input>
            </el-form-item>

            <el-form-item label="人事变更代码" label-width="100px">
              <el-select v-model.number="personnelform.change" placeholder="请选择变更代码">
                <el-option label="新员工加入-1" value="1"></el-option>
                <el-option label="职务变动-2" value="2"></el-option>
                <el-option label="辞退-3" value="3"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="详细记录" label-width="100px">
              <el-input type="textarea" v-model="personnelform.description" placeholder="详细记录"></el-input>
            </el-form-item>
          </el-form>

          <div slot="footer" class="dialog-footer">
            <el-button @click="showPsnl = false">取 消</el-button>
            <el-button :plain="true" type="primary" @click="personnelChange">提 交</el-button>
          </div>
        </el-dialog>

        <!--人事记录-->
        <el-table
          v-show="showPsnlList"
          v-loading.fullscreen.lock="personnelLoading"
          :data="personneldata"
        >
          <el-table-column prop="id" label="记录编号" width="140"></el-table-column>
          <el-table-column prop="person" label="员工号" width="140"></el-table-column>
          <el-table-column prop="change" label="变更代码" width="140"></el-table-column>
          <el-table-column prop="description" label="详细记录" width="140"></el-table-column>
        </el-table>

        <!--部门列表-->
        <el-table v-show="showDpList" :data="Dpdata">
          <el-table-column prop="id" label="部门编号" width="140"></el-table-column>
          <el-table-column prop="name" label="部门名称" width="140"></el-table-column>
          <el-table-column prop="manager" label="部门经理" width="140"></el-table-column>
          <el-table-column prop="intro" label="描述" width="300"></el-table-column>
        </el-table>

        <!--工作列表-->
        <el-table v-show="showJobList" :data="Jobdata">
          <el-table-column prop="code" label="职务编号" width="140"></el-table-column>
          <el-table-column prop="description" label="职务" width="140"></el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { METHODS } from "http";
import request from "../axios";
export default {
  data() {
    return {
      persondata: [], //全部员工数据
      Dpdata: [],
      Jobdata: [],
      fullscreenLoading: false, //加载显示
      personnelLoading: false,
      oneperson: [], //单个员工查找数据
      personneldata: [], //人事记录列表
      showPerson: false, //单个员工列表显示
      showAll: false, //全部员工列表显示
      showUp: false, //弹窗更新显示
      showPsnl: false, //人事变动弹窗显示
      showPsnlList: false, //人事记录列表显示
      showDpList: false, //部门列表显示
      showJobList: false, //工作列表显示
      dialogFormVisible: false, //弹窗
      formLabelWidth: "120px",
      form: {
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
      },
      updateform: {
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
      },
      personnelform: {
        id: 0,
        person: 0,
        change: 0,
        description: ""
      }
    };
  },
  methods: {
    getonebtn() {
      //查询员工
      this.$prompt("请输入员工号", "查询", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        inputPattern: /^[0-9]+.?[0-9]*/,
        inputErrorMessage: "员工号必须为数字"
      })
        .then(({ value }) => {
          this.showPerson = true;
          this.showUp = false;
          this.getone(value);
          this.showAll = false;
          this.showPsnlList = false;
          this.showDpList = false;
          this.showJobList = false;
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
    },
    getone(v) {
      //查询单个员工请求
      this.oneperson = [];
      let that = this;
      request({
        url: "/persons/" + v,
        method: "GET"
      })
        .then(response => {
          var person = response.data;
          //   console.log(person);
          if (
            person.authority == null ||
            person.authority == "" ||
            person.authority == "null"
          )
            person.authority = "无权限";
          if (person.remark == null) person.remark = "无备注";
          if (person.spcialty == null) person.spcialty = "无特长";
          if (person.state == true) person.state = "在职";
          else person.state = "离职";
          that.oneperson.push(person);

          that.$message({
            type: "success",
            message: "查询成功"
          });
        })
        .catch(err => {
          console.log(err);
          alert("用户不存在");
        });
    },
    getall() {
      //查询所有员工
      this.showAll = !this.showAll;
      this.showPerson = false;
      this.showUp = false;
      this.showDpList = false;
      this.showJobList = false;
      this.fullscreenLoading = true;
      this.persondata = [];
      let that = this;
      var msg = request({
        url: "persons/all",
        method: "GET"
      })
        .then(response => {
          let list = response.data;
          for (let i = 0; i < list.length; i++) {
            if (this.persondata.indexOf(list[i]) == -1) {
              if (
                list[i].authority == null ||
                list[i].authority == "" ||
                list[i].authority == "null"
              )
                list[i].authority = "无权限";
              if (list[i].remark == null) list[i].remark = "无备注";
              if (list[i].spcialty == null) list[i].spcialty = "无特长";
              if (list[i].state == true) list[i].state = "在职";
              else list[i].state = "离职";
              this.persondata.push(list[i]);
            }
          }
          this.fullscreenLoading = false;
          that.$message({
            type: "success",
            message: "查询成功"
          });
        })
        .catch(err => {
          that.$message.error("查询失败");
        });
    },
    addNewPerson() {
      //新增员工
      this.dialogFormVisible = false;
      if(this.form.passwd == null ||this.form.passwd == "")
      this.form.passwd = "000000";
      let req = request({
        url: "persons/new_person",
        method: "POST",
        data: this.form,
        headers: {
          "Content-Type": "application/json"
        }
      })
        .then(response => {
          this.$message({
            message: "新增成功,员工号为",
            type: "success"
          });
          this.form = {};
        })
        .catch(err => {
          this.$message.error("新增失败!");
        });
    },
    //更新
    updatePerson() {
      this.showPerson = false;
      this.showAll = false;
      this.showUp = true;
      let self = this;
      this.$prompt("请输入员工号", "更改", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        inputPattern: /^[0-9]+.?[0-9]*/,
        inputErrorMessage: "员工号必须为数字"
      })
        .then(({ value }) => {
          this.getone2(value);
        })
        .catch(err => {
          //console.log(err);
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
    },
    getone2(v) {
      this.updateform = {};
      let that = this;
      request({
        url: "/persons/" + v,
        method: "GET"
      })
        .then(response => {
          var person = response.data;
          this.updateform = person;
        })
        .catch(err => {
          console.log(err);
          alert("用户不存在");
        });
    },
    submitForm(form) {
      //   console.log(this.updateform);
      let that = this;
      request({
        url: "/persons/person/" + form.id,
        method: "PUT",
        data: this.updateform,
        headers: {
          "Content-Type": "application/json"
        }
      })
        .then(response => {
          that.$message({
            type: "success",
            message: response.data
          });
          that.showUp = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    //人事变动
    personnelChange() {
      this.showPsnl = false;
      let self = this;
      request({
        url: "/personnel/new_personnel",
        method: "POST",
        data: this.personnelform,
        headers: {
          "Content-Type": "application/json"
        }
      })
        .then(response => {
          self.$message(response.data.msg);
        })
        .catch(err => {
          console.log(err);
        });
    },
    //人事记录
    getPersonnel() {
      this.showPsnlList = !this.showPsnlList;
      this.showAll = false;
      this.showPerson = false;
      this.showUp = false;
      this.showDpList = false;
      this.showJobList = false;
      this.personneldata = [];
      let that = this;
      request({
        url: "personnel/all",
        method: "GET"
      })
        .then(response => {
          let list = response.data;
          for (let i = 0; i < list.length; i++) {
            if (this.personneldata.indexOf(list[i]) == -1) {
              switch (list[i].change) {
                case 1:
                  list[i].change = "新员工加入-1";
                  break;
                case 2:
                  list[i].change = "职务变动";
                  break;
                case 3:
                  list[i].change = "辞退";
                  break;
              }
              this.personneldata.push(list[i]);
            }
          }
          that.$message({
            type: "success",
            message: "查询成功"
          });
        })
        .catch(err => {
          console.log(err);
          thst.$message.error("查询失败");
        });
    },
    //部门查询
    getDp() {
      this.showDpList = !this.showDpList;
      this.showPsnlList = false;
      this.showAll = false;
      this.showPerson = false;
      this.showUp = false;
      this.showJobList = false;
      this.Dpdata = [];
      let that = this;
      request({
        url: "departments/all",
        method: "GET"
      })
        .then(response => {
          let list = response.data;
          for (let i = 0; i < list.length; i++) {
            this.Dpdata.push(list[i]);
          }
          that.$message({
            type: "success",
            message: "查询成功"
          });
        })
        .catch(err => {
          console.log(err);
          thst.$message.error("查询失败");
        });
    },
    //工作查询
    getJob() {
      this.showJobList = !this.showJobList;
      this.showDpList = false;
      this.showPsnlList = false;
      this.showAll = false;
      this.showPerson = false;
      this.showUp = false;
      this.Jobdata = [];
      let that = this;
      request({
        url: "jobs/all",
        method: "GET"
      })
        .then(response => {
          let list = response.data;
          for (let i = 0; i < list.length; i++) {
            this.Jobdata.push(list[i]);
          }
          that.$message({
            type: "success",
            message: "查询成功"
          });
        })
        .catch(err => {
          console.log(err);
          thst.$message.error("查询失败");
        });
    }
  }
};
</script>

<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>