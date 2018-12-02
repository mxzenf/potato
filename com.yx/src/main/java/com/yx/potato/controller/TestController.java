package com.yx.potato.controller;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseContorller {

  @GetMapping(value = "/users/list")
//  @PostMapping(value = "/users/list")
  @SuppressWarnings("all")
  public String listUser(@RequestParam(value="access_token") String token){
      OAuth2AccessToken oat = parseToken(token);
      return "user";
  }

  @GetMapping(value = "/opt/list")
  public String optList(){
      return "optList";
      /*
       * claims = Jwts.parser().setSigningKey("SigningKey".getBytes("UTF-8")).parseClaimsJws(token).getBody();
       */
  }

}
