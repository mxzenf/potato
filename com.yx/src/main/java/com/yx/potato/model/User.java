package com.yx.potato.model;

import java.util.Collection;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
public class User implements UserDetails {

  @Setter
  private String username;
  @Setter
  private String password;
  @Setter
//  private List<Authorities> authorities;
  private List<? extends GrantedAuthority> authorities;
  @Setter
  @Getter
  private String nickname;
  @Setter
  @Getter
  private String userid;
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
