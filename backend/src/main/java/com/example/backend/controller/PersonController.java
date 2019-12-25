package com.example.backend.controller;

import com.example.backend.mapper.PersonMapper;
import com.example.backend.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    //查询所有
    @GetMapping("/all")
    public List<Person> getAll(){
        List<Person> list = personMapper.selectAll();
        return list;
    }

    //新增员工
    @PostMapping("/new_person")
    public Map<String,Object> addperson(@RequestBody Person person){
        System.out.println(person);
        Map<String ,Object> map = new HashMap<>();
        if(person.getPasswd()==null){
            person.setPasswd("123456");
        }
        try{
            personMapper.insertPerson(person);
            System.out.println("增加成功");
            map.put("msg","新增成功!");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("增加失败");
            map.put("msg","新增失败!");
            return map;
        }
    }

    //查询单个员工
    @GetMapping("/{id}")
    public Person personMessage(@PathVariable("id") int id){
        return personMapper.selectPerson(id);
    }

    //修改员工资料
    @PutMapping("/person/{id}")
    public String updatePerson(@RequestBody Person person,@PathVariable("id") int id){
        person.setId(id);
        try{
            personMapper.update(person);
            System.out.println("更新成功--更新为下：");
            System.out.println(person);
            return "ok";
        }catch (Exception e){
            System.out.println("更新失败");
            e.printStackTrace();
        }
        return "false";
    }

}
