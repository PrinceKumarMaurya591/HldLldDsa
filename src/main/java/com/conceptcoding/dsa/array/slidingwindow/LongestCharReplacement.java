package com.conceptcoding.dsa.array.slidingwindow;

import java.util.HashMap;
//Algo revice and pratics coading also forgetting
//Create a frequency map count and initialize l = 0, maxf = 0, and res = 0.
//Move the right pointer r across the string:
//Update the frequency of s[r].
//Update maxf with the highest frequency seen so far.
//If the window is invalid (window size - maxf > k):
//Shrink the window from the left and adjust counts.
//Update the result with the valid window size.
//Return res at the end.
public class LongestCharReplacement {

    public static void main(String[] args) {
        String s="ABAB";
        int k=2;
        longestCharReplacement(s,k);
    }

    public static int longestCharReplacement(String s,int k) {

            HashMap<Character, Integer> count = new HashMap<>();
            int res = 0;

            int l = 0, maxf = 0;
            for (int r = 0; r < s.length(); r++) {
                count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
                maxf = Math.max(maxf, count.get(s.charAt(r)));

                while ((r - l + 1) - maxf > k) {
                    count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
    }
}
