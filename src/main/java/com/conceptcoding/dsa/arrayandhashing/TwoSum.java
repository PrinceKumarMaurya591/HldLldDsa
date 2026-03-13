package com.conceptcoding.dsa.arrayandhashing;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int [] nums={3,4,5,6};
        int target=9;

       int[] res= twoSum(nums,target);
        System.out.println(Arrays.toString(res));

    }
//   return new int[]{mp.get(target-nums[i]),i}; this part forgetting
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],i);
            if(mp.containsKey(target-nums[i])){
                return new int[]{mp.get(target-nums[i]),i};
            }
            mp.put(nums[i],i);
        }
        return null;

    }


}
