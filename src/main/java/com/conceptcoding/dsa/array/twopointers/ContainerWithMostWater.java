package com.conceptcoding.dsa.array.twopointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = {1, 7, 2, 5, 4, 7, 3, 6};
        System.out.println( containerWithMostWater(arr));
    }

    public static int containerWithMostWater(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
