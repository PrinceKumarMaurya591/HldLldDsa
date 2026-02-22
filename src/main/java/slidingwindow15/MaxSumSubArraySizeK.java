package slidingwindow15;

public class MaxSumSubArraySizeK {

    public static void main(String[] args) {
        int[] arr={100, 200, 300, 400};
        int k=2;
        System.out.println( maxSumSubArray(arr,k));

    }

    public static int maxSumSubArray(int[] arr,int k){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            currSum+=arr[i];
        }
        // forgetting
//        Correct Logic
//        Window should:
//        Remove left element → arr[j - k]
//        Add new right element → arr[j]
//        Update maxSum
        for(int j=k;j<arr.length;j++){
            currSum=currSum+arr[j]-arr[j-k];
            maxSum=Math.max(maxSum,currSum);

        }
        return maxSum;
    }

}
