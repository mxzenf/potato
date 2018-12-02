package com.yx.potato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 
 * @author 杨欣
 *
 */
public class BaseContorller {
  @Autowired
  private TokenStore tokenStore;
  
  protected OAuth2AccessToken parseToken(String token){
    return tokenStore.readAccessToken(token);
  }
}
