package com.learnjava.demotlias.mapper;

import com.learnjava.demotlias.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> getDept();

    @Delete("DELETE FROM dept WHERE id = #{id}")
    void deleteByID(Integer id);

    @Insert("INSERT INTO dept(name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void addDept(Dept dept);

    @Select("SELECT id, name, create_time, update_time FROM dept WHERE id = #{id}")
    List<Dept> getByID(Integer id);

    @Update("UPDATE dept SET name = #{name},update_time = #{updateTime} WHERE id = #{id}")
    void update(Dept dept);
}
