package com.conceptcoding.dsa.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EvenNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        list.stream().filter(x->x%2==0).forEach(System.out::println);

        //find dublicate
        List<Integer>dublicateList=Arrays.asList(1,2,3,4,5,6,5,4);
        Set<Integer> set=new HashSet<>();
        dublicateList.stream().
                filter(x->!set.add(x)).forEach(System.out::println);

        //
    }


}
