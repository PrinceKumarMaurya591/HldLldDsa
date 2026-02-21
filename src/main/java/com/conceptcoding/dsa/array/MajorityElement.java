package com.conceptcoding.dsa.array;


//forget logic so revise it
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr={3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] arr) {
        int candidate=arr[0];
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(count==0){
                candidate=arr[i];
                count++;
            }else if(arr[i]==candidate){
                count++;
            }else count--;
        }
       int freq=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==candidate){
                freq++;
            }
            if(freq>arr.length/2){
                return candidate;
            }
        }
return -1;
    }

}
