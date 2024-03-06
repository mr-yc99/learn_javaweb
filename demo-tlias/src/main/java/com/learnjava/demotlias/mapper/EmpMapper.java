package com.learnjava.demotlias.mapper;

import com.learnjava.demotlias.pojo.Emp;
import com.learnjava.demotlias.pojo.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    @Select("SELECT COUNT(*) FROM emp")
//    public Long countRow();
//
//    @Select("SELECT * FROM emp LIMIT #{start}, #{pageSize}")
//    public List<Emp> getEmp(Integer start, Integer pageSize);


//    @Select("SELECT * FROM emp")
    public List<Emp> getByPage(String name, Short gender, LocalDate begin, LocalDate end);


    void deleteByID(List<Integer> ids);


    void addEmp(Emp emp);

    void putEmp(Emp emp);

    @Select("SELECT * FROM emp WHERE id = #{id}")
    Emp getByID(Integer id);

    /**
     * 登入
     * @param emp
     * @return
     */
    @Select("SELECT * FROM emp WHERE username = #{username} AND password = #{password}")
    Emp processLogin(Emp emp);



    @Delete("DELETE FROM emp WHERE dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);

}
