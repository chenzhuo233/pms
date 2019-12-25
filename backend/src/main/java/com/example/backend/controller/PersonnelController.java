package com.example.backend.controller;

import com.example.backend.mapper.PersonnelMapper;
import com.example.backend.pojo.Personnel;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("personnel")
public class PersonnelController {
    @Autowired
    private PersonnelMapper personnelMapper;

    //Insert
    @PostMapping("/new_personnel")
    public Map<String,Object> insert(@RequestBody Personnel personnel) {
        Map<String, Object> map = new HashMap<>();
        try {
            personnelMapper.insertPnl(personnel);
            System.out.println("新增成功！----> 新增如下");
            System.out.println(personnel);
            map.put("msg","新增成功");
            return map;
        } catch (Exception e) {
            System.out.println("新增失败");
            map.put("msg",e.toString());
            return map;
        }
    }

    //Delete
    @DeleteMapping("/{id}")
    public Map<String,Object> delete(@PathVariable("id") int id){
        Map<String,Object> map = new HashMap<>();
        try {
            personnelMapper.deletePnl(id);
            map.put("msg","删除成功");
            return map;
        }catch (Exception e){
            map.put("msg",e.toString());
            return map;
        }
    }


    //Update
    @PutMapping("/{id}")
    public Map<String,Object> update(@RequestBody Personnel personnel){
        Map<String,Object> map = new HashMap<>();
        try{
            personnelMapper.updatePnl(personnel);
            map.put("msg","更新成功");
            return map;
        }catch (Exception e){
            System.out.println("更新失败");
            map.put("msg",e.toString());
            return map;
        }
    }

    //Select
    @GetMapping("/all")
    public List<Personnel> select(){
        List<Personnel> list = personnelMapper.selectPnl();
        return list;
    }

}
