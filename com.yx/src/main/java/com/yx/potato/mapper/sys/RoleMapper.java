package com.yx.potato.mapper.sys;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface RoleMapper {
  @Select("select role_id from sys_user_role where user_id=#{userId}")
  List<String> listByUserId(String userId);
}
