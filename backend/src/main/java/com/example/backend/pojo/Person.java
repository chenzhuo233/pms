package com.example.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String passwd;
    private String authority;//权限
    private String name;
    private String sex;
    private String birthday;
    private String department;//部门
    private int job;
    private int eduLevel;
    private String spcialty;//专业技能
    private String address;//住址
    private String tel;
    private String email;
    private boolean state;//状态
    private String remark;//备注
}
