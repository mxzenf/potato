package com.potato.pingyin;

import junit.framework.Assert;

import org.junit.Test;

import com.yx.potato.common.PinyinUtil;

public class PinyinUtilTest {
  
  @Test
  public void test_head(){
    String str = PinyinUtil.getPinYinHeadChar("杨欣");
    for(String s : PinyinUtil.getPinYin('欣')){
      System.out.println(s);
    }
    Assert.assertEquals("yx", str);
  }
  
}
