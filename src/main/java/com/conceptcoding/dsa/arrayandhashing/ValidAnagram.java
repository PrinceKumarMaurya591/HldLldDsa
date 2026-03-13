package com.conceptcoding.dsa.arrayandhashing;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "racecar", t = "carrace";
        System.out.println(isAnagram(s,t));
    }

    //pura logic hi bhool ja rha tha count[s.charAt(i)-'a']++;
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){return false;}

        int [] count=new int[26];
        for(int i=0;i<s.length();i++){
         count[s.charAt(i)-'a']++;
         count[s.charAt(i)-'a']--;

        }
        for(int val:count){
            if(val!=0){return false;}
        }

      return true;
    }

}
