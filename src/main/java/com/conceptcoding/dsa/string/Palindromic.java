package com.conceptcoding.dsa.string;

public class Palindromic {
    public static void main(String[] args) {
        String str="abccba";
        System.out.println(palindrom(str));
    }
    public  static boolean palindrom(String str){
        int len=str.length();
        int left=0;
        int right=len-1;
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
