package com.conceptcoding.dsa.array;

public class LeadersInArray {

    public static void main(String[] args) {
        int[] arr={16, 17, 4, 3, 5, 2};
        leaders(arr);

    }

    public static void leaders(int[] arr){
        int n=arr.length;
        int leader=arr[n-1];
        System.out.print(leader + " "); // Last leader
        for(int i=n-2;i>=0;i--){
            if(leader<arr[i]){
                leader=arr[i];
                System.out.print    (leader+" ");
            }
        }

    }

}
