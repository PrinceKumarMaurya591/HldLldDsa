package com.conceptcoding.dsa.array.arrayandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        groupAnagram(strs);
    }

    public static void groupAnagram(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s:strs){
            int [] arr = new int[26];
            Arrays.fill(arr,0);
            for(int i=0;i<s.length();i++){
                arr[s.charAt(i)-'a']++;
            }
        }
    }



}
