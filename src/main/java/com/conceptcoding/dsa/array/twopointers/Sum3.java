package com.conceptcoding.dsa.array.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//revise
public class Sum3 {

    public static void main(String[] args) {

        int[] arr={-1,0,1,2,-1,-4};
        List<List<Integer>>results= threeSum(arr);
        for (List<Integer> list : results) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> threeSum(int[] arr){
        Arrays.sort(arr);
       List<List<Integer>> list=new ArrayList<>();
       for(int i=0;i<arr.length-2;i++){
           if(i>0&&arr[i]==arr[i-1]){continue;}//skip dublicate
           int left=i+1;
           int right=arr.length-1;
           while(left<right){
             int sum=arr[i]+arr[left]+arr[right];
             if(sum==0){
                 list.add(Arrays.asList(arr[i],arr[left],arr[right]));
                 left++;
                 right--;
                 while(left<right&&arr[left]==arr[left-1]){left++;}//Avoid duplicate triplets.
                 while(left<right&&arr[right]==arr[right-1]){right--;}//Avoid duplicate triplets.
             }
            else if(sum>0){
                 left++;
             }
             else{
                 right--;
             }
           }
       }
       return list;
    }
}
