package com.yx.potato.oauth2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest arg0, HttpServletResponse arg1,
      AuthenticationException arg2) throws IOException, ServletException {
    log.info("      ========================================= 身份认证失败..................... ");

    arg1.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Access Denied");

  }

}
