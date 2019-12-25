package com.example.backend.mapper;

import com.example.backend.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonMapper {
    //查询全部员工
    @Select("select * from person")
    List<Person> selectAll();

    //增加新员工
    void insertPerson(@Param("person") Person person);

    /*员工信息操作*/
    /*Select*/
    Person selectPerson(@Param("id") int id);

    /*Update*/
    void update(@Param("person") Person person);

}
