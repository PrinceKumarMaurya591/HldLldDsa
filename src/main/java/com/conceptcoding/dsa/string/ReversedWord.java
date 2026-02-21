package com.conceptcoding.dsa.string;

public class ReversedWord {
    public static void main(String[] args) {
        String word="My name is prince kumar maurya";
        System.out.println( reversedWord(word));
    }

    public static String reversedWord(String word){
        String[] words = word.split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]).append(" ");
             }
        return sb.toString();
    }
}
