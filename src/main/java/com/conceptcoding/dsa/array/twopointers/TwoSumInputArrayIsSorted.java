package com.conceptcoding.dsa.array.twopointers;

import java.util.Arrays;

// see once not stuck at once two pointer
public class TwoSumInputArrayIsSorted {

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5 };
        int target=4;

        int[] result=targetSum(arr,target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] targetSum(int[] arr,int target){
        int left=0;int right=arr.length-1;

        while (left<right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        return new int[]{-1,-1};

    }
}
