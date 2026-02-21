package com.conceptcoding.dsa.string;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        String str1 = "abaac";
        String str2 = "aacbd";
        System.out.println(anagram(str1,str2));
    }
  public static boolean anagram(String s1, String s2) {
       char[] ch1= s1.toCharArray();
       char[] ch2 = s2.toCharArray();
      Arrays.sort(ch1);
      Arrays.sort(ch2);
      if(Arrays.equals(ch1,ch2)){
          return true;
      }
      return false;


  }

}
