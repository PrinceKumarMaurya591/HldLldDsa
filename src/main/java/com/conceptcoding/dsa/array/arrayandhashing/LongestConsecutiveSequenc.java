package com.conceptcoding.dsa.array.arrayandhashing;

import java.util.HashSet;
import java.util.Set;


//totaly blank so revise it
public class LongestConsecutiveSequenc {

    public static void main(String[] args) {
        int[] arr={2,20,4,10,3,4,5};
        System.out.println(longestConsecutiveSequenc(arr));
    }

    public static int longestConsecutiveSequenc(int[] nums){


                Set<Integer> numSet = new HashSet<>();
                for (int num : nums) {
                    numSet.add(num);
                }
                int longest = 0;

                for (int num : numSet) {
                    if (!numSet.contains(num - 1)) {
                        int length = 1;
                        while (numSet.contains(num + length)) {  //
                            length++;
                        }
                        longest = Math.max(longest, length);
                    }
                }
                return longest;
    }
}
