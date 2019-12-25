package com.example.backend.mapper;

import com.example.backend.pojo.Personnel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonnelMapper {
    /*人事变动*/

    //Insert
    @Insert("insert into personnel(ID,PERSON,`CHANGE`,DESCRIPTION) values(#{id},#{person},#{change},#{description})")
    void insertPnl(Personnel personnel);

    //Delete
    @Delete("delete from personnel where ID=#{id}")
    void deletePnl(@Param("id") int id);

    //Update
    @Update("update personnel set PERSON=#{personnel.person},CHANGE=#{personnel.change},DESCRIPTION=#{description} where ID=#{personnel.id}")
    void updatePnl(@Param("personnel") Personnel personnel);

    //Select
    @Select("select * from personnel")
    List<Personnel> selectPnl();
}
