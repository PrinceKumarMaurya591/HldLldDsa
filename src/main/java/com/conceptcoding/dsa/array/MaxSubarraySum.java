package com.conceptcoding.dsa.array;

public class MaxSubarraySum {
    public static void main(String[] args) {

//        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int [] arr={-2, -5, 6, -2, -3, 1, 5, -6};
        System.out.println( maxSubArraySum(arr));
    }
    private static int maxSubArraySum(int[] arr) {
        int n=arr.length;
        int maxSum=arr[0];
        int currSum=arr[0];
        for (int i = 1; i < n; i++) {
           currSum=Math.max(currSum+arr[i],arr[i]);
           maxSum=Math.max(maxSum,currSum);

        }
        return maxSum;

    }


    }

