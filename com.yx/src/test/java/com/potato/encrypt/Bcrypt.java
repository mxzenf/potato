package com.potato.encrypt;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bcrypt {
  private BCryptPasswordEncoder epe;

  @Before
  public void setUp(){
    epe = new BCryptPasswordEncoder();
  }
  
  @Test
  public void test_en(){
//    System.out.println(epe.encode("111111"));
    User user = (User) User.withDefaultPasswordEncoder()
        .username("admin")
        .password("1")
        .roles("ADMIN")
        .build();
    System.out.println(user.getPassword());
  }
  
}
