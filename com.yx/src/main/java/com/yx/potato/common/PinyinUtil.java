package com.yx.potato.common;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import junit.framework.Assert;
import net.sourceforge.pinyin4j.PinyinHelper;

import org.junit.Test;

public class PinyinUtil {

  /**
   * 传入中文获取首字母 （小写） 如：杨欣-> yx
   * 
   * @param str
   *          需要转化的中文字符串
   * @return
   */
  public static String getPinYinHeadChar(String str) {
    String convert = "";
    for (int j = 0; j < str.length(); j++) {
      char word = str.charAt(j);
      String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
      if (pinyinArray != null) {
        convert += pinyinArray[0].charAt(0);
      } else {
        convert += word;
      }
    }
    return convert;
  }

  public static String[] getPinYin(char word) {
    return PinyinHelper.toHanyuPinyinStringArray(word);
  }
  @Test
  public void test_head(){
    String str = PinyinUtil.getPinYinHeadChar("杨欣");
    Assert.assertEquals("yx", str);
    
  }
}
