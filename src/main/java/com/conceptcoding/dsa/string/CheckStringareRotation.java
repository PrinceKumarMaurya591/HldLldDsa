package com.conceptcoding.dsa.string;

public class CheckStringareRotation {

    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "abcm";
        System.out.println(checkRotation(s1,s2));
    }
    private static boolean checkRotation(String s1, String s2) {
        String s3 = s1 + s1;
        if(s3.contains(s2)){
            return true;
        }
        return false;

    }
}
