package com.conceptcoding.dsa.array.twopointers;

public class ValidPalindrome   {

    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw";
        System.out.println( isPalindrome(s));
    }

    public static boolean isPalindrome(String str) {
         str=str.toLowerCase();
         str=str.replaceAll(" ", "");
      int left=0;int right=str.length()-1;
      while(left<right){
          if(str.charAt(left)!=str.charAt(right)){
              return false;
          }
          left++;
          right--;
      }
      return true;
    }

}
