package com.learnjava.mapper;

import com.learnjava.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT id FROM USER")
    public List<User> list();



}
