package com.conceptcoding.dsa.array;

public class leftRotateArrayByDPlace {
    public static void main(String[] args) {
       int arr[]={1,3,5,6,7,8};
       int k=2;
        int rotatedArrya[]= rotate(arr,k);
        for(int i=0;i<rotatedArrya.length;i++){

            System.out.print(rotatedArrya[i]+" ");
        }
    }

    public static int[] rotate(int[] arr,int k){
        int n=arr.length;
        k = k % n;  //mai isko miss kr rha tha
        temp(arr,0,k-1);
        temp(arr,k,n-1);
        temp(arr,0,n-1);
        return arr; //aur isko bbhi to return hoga
    }
    public static void temp(int[] arr,int i,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}
