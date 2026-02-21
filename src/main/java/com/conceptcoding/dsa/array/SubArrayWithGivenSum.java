package com.conceptcoding.dsa.array;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr={1,4,20,3,10,5};
        int sum=490;
        System.out.println(subarraySum(arr,sum));
    }
    public static boolean subarraySum(int[] arr,int sum){
        int currSum=arr[0];
       int s=0;
        for(int i=1;i<arr.length;i++){
            currSum+=arr[i];
            while(currSum>sum){
             currSum=currSum-arr[s];
             s++;
            }
            if(currSum==sum){
                return true;
            }
        }
       return false;
    }
}
