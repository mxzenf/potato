package com.yx.potato.mapper.sys;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yx.potato.model.Authorities;

@Mapper
public interface AuthoritiesMapper {
  
  @Select("SELECT " +
          "y.authority ," +
          "y.authority_name AS authorityName " +
          "FROM " +
          "sys_role_authorities x, " +
          "sys_authorities y " +
          "WHERE " +
          "role_id IN ( " +
          "SELECT " +
          "b.role_id " +
          "FROM " +
          "sys_user a, " +
          "sys_user_role b " +
          "WHERE " +
          "a.user_id = b.user_id " +
          "and a.user_id = #{userId}) " +
          "AND x.authority = y.authority"
          )
  List<Authorities> listByUserId(String userId);
}
