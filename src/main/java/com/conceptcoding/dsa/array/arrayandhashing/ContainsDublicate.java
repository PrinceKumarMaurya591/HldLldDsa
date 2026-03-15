package com.conceptcoding.dsa.array.arrayandhashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDublicate {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4};
        System.out.println(hasDuplicate(arr));

    }

    //kha    set.add(num); add krna hai bhool gya tha
    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){

           if(set.contains(num)){
               return true;
           }
            set.add(num);

        }

        return false;
    }

}
