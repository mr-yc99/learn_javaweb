package com.learnjava.mapper;

import com.learnjava.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("DELETE FROM emp where id = #{id}")
    public int deleteEmp(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "VALUES (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insertEmp(Emp emp);

    @Update("UPDATE emp SET username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}," +
            "entrydate =  #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime}" +
            " WHERE id = #{id}")
    public void update(Emp emp);

    //由于Emp实体类中属性名和数据库的字段名不一致，会导致查询出来的值不能够封装到Emp中
//    方案一：在SELECT中设置别名
//    方案二：使用Results和Result可以完成不一致字段和属性名的对应
//    开启自动映射
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "update_time", property = "updateTime"),
//            @Result(column = "create_time", property = "createTime")
//    })
    @Select("SELECT * FROM emp WHERE id = #{id}")
    public Emp queryByID(Integer id);

//    @Select("SELECT *" +
//            "FROM emp " +
//            "WHERE name like CONCAT('%', #{name}, '%') AND gender = #{gender} AND entrydate BETWEEN #{begin} AND #{end} " +
//            "ORDER BY update_time DESC")
    public List<Emp> queryByTerm(String name, Short gender, LocalDate begin, LocalDate end);

//    动态更新
    public void updateTrend(Emp emp);

    public void deleteByIDs(List<Integer> IDs);

}
