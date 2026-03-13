package slidingwindow15;

import java.lang.reflect.Array;
import java.util.*;

public class Rough {

    public static void main(String[] args) {
        int arr[] = {100, 4, 200, 1, 3, 2};

        int arr1 = longestConsecutive(arr);
        System.out.println(arr1);

    }
    public static int longestConsecutive(int[] arr){
         int maxLen=0;
         Set<Integer> set=new HashSet<>();
        for(int num:arr){
            set.add(num);
        }

        for(int num:set){
            if(!set.contains(num-1)){
                int currNum=num;
                int currLen=1;
                while(set.contains(currNum+1)){
                    currLen++;
                    currNum+=1;
                }
                maxLen=Math.max(maxLen,currLen);
            }

        }
        return maxLen;


    }
}