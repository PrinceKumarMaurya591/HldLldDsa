package com.conceptcoding.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class FreqInSortedArray {
    public static void main(String[] args) {
        int arr[]={1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10};
        frequency(arr);
    }
    public static void frequency(int[] arr){
        Map<Integer,Integer> maps=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            maps.put(arr[i],maps.getOrDefault(arr[i],0)+1);

        }
       for(Map.Entry<Integer,Integer> entry:maps.entrySet()){
           System.out.println(entry.getKey()+" "+entry.getValue());
       }

    }
}
