package com.conceptcoding.dsa.array;

public class move0toEnd {
    public static void main(String[] args) {
        int [] arr={1, 2, 0, 0, 0, 3, 6};
       int outputArr[]= moveZero(arr);
        for (int i=0;i<outputArr.length;i++){
            System.out.print(outputArr[i]+" ");
        }
    }
    //mai two pointer last wala le rha tha to order mismatch ho rha tha
    public static int[] moveZero(int[] arr){
        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=0){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }

        }
        return arr;

    }

}
