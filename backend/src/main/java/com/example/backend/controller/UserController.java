package com.example.backend.controller;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getAll")
    public List<User> getalluser() {
        List<User> list = userMapper.getalluser();
        for (User user : list) {
            System.out.println(user);
        }
        return list;
    }

    @GetMapping("/getId")
    public User getIdUser(String id) {
        User user = userMapper.getIdUser(id);
        return user;
    }

    @GetMapping("/inert")
    public String insertId() {
        userMapper.insertId("1","wmm","991222");
        List<User> list = userMapper.getalluser();
        for (User user1 : list) {
            System.out.println(user1);
        }
        return "ok";
    }

    @GetMapping("/update")
    public String  updateUser() {
        userMapper.updateUser("1","chenzhuo","991222");
        return "ok";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
            userMapper.deleteUser(id);
            System.out.println("deleted ok");
            return "ok";
    }
}
