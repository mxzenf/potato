package com.yx.potato.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yx.potato.mapper.sys.AuthoritiesMapper;
import com.yx.potato.mapper.sys.RoleMapper;
import com.yx.potato.mapper.sys.UserMapper;
import com.yx.potato.model.User;

@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private AuthoritiesMapper authoritiesMapper;
  @Autowired
  private RoleMapper roleMapper;

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    User user = userMapper.findUserByName(username);
    if (null == user) {
      throw new UsernameNotFoundException("无效用户");
    }
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    authorities.addAll(authoritiesMapper.listByUserId(user.getUserid()));
    authorities.addAll(getGrantedRole(roleMapper.listByUserId(user.getUserid())));
    user.setAuthorities(authorities);
    
    return user;
  }

  private List<SimpleGrantedAuthority> getGrantedRole(List<String> roles) {
    List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
    for (String role : roles) {
      SimpleGrantedAuthority ga = new SimpleGrantedAuthority("ROLE_"+role.toUpperCase());
      grantedAuthorities.add(ga);
    }
    return grantedAuthorities;
  }
}
