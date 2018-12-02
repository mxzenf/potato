package com.yx.potato.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Setter
  private String authority;
  @Setter
  @Getter
  private String authorityName;
  
  @Override
  public String getAuthority() {
    return this.authority;
  }

}
