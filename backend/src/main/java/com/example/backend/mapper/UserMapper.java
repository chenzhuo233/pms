package com.example.backend.mapper;

import com.example.backend.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    //获取全部user
    @Select("select * from users")
    List<User> getalluser();
    //id查找user
    @Select("select * form users where id = #{id}")
    User getIdUser(String id);
    //插入user
    /*@Results({
            @Result(property = "id" , column = "ID"),
            @Result(property = "username" , column = "NAME"),
            @Result(property = "password" , column = "PASSWORD")
    })*/
    @Insert("insert into users(id,name,password) values(#{id},#{name},#{password})")
    int insertId(@Param("id") String  id,@Param("name") String name,@Param("password") String password );
    //修改user
    @Update("update users set username=#{username},password=#{password} where id=#{id}")
    void updateUser(@Param("id") String  id,@Param("username") String username,@Param("password") String password );
    //删除user
    @Delete("delete from users where id=#{id}")
    void deleteUser(String id);
}
