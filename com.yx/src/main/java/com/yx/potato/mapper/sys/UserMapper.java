package com.yx.potato.mapper.sys;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yx.potato.model.User;


@Mapper
public interface UserMapper {

  @Select("select username,password,nick_name as nickname,user_id as userid from sys_user where username=#{username}")
  User findUserByName(String username);
  
}
