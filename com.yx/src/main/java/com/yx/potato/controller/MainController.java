package com.yx.potato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yx.potato.common.JsonResult;
import com.yx.potato.model.User;

/**
 * 
 * @author 杨欣 获取用户信息
 */
@RestController
public class MainController extends BaseContorller {
  @Autowired
  private UserDetailsService userService;

  @RequestMapping("/userInfo")
  public JsonResult userInfo(@RequestParam(value = "access_token") String token) {
    User user = (User) userService.loadUserByUsername(parseToken(token)
        .getAdditionalInformation().get("user_name") + "");
    user.setPassword("");
    return JsonResult.ok().put("user", user);
  }

}
