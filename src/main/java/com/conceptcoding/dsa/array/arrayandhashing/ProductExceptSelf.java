package com.conceptcoding.dsa.array.arrayandhashing;


//neetcode 4. Prefix & Suffix (Optimal) not able to code
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] result=productExceptSelf(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    public static int[] productExceptSelf(int[] arr){
        int [] result=new int[arr.length];
        result[0]=1;
        int prefix=1;
        for(int i=1;i<arr.length;i++){
            result[i]=prefix;
            prefix*=arr[i];
        }
        int postfix=1;
        for(int i=arr.length-1;i>0;i--){
            result[i]=result[i]*postfix;
            postfix*=arr[i];

        }
        return result;
    }

}
