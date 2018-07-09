package com.guoxu.maximumsubarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

//    public int crossMid(int [] nums,int left,int right) {
//        int mid = (left + right) / 2;
//        if(left == right) {
//            return nums[left];
//        }
//        int leftSum = 0;
//        int tempLeftSum = 0;
//        int rightSum = 0;
//        int tempRightSum = 0;
//        int maxLeftSum = crossMid(nums,left,mid);
//        int maxRightSum = crossMid(nums,mid + 1,right);
//        for (int i = mid;i >= left;i--) {
//            tempLeftSum += nums[i];
//            if (tempLeftSum > leftSum) {
//                leftSum = tempLeftSum;
//            }
//        }
//        for ( int i = mid + 1;i <= right;i++) {
//            tempRightSum += nums[i];
//            if (tempRightSum > rightSum) {
//                rightSum = tempLeftSum;
//            }
//        }
//        return Math.max(maxLeftSum,Math.max(maxRightSum,leftSum + rightSum));
//    }
//    public findMaxSum(int[] nums,int left,int right) {
//
//    }
//    public int maxSubArray(int[] nums) {
//        return findMaxSum(nums,0,nums.length - 1);
//    }

//    public int maxSubArray(int[] nums) {
//        return Subarray(nums, 0 ,nums.length -1 );
//    }
//    public int Subarray(int[] A,int left, int right){
//        if(left == right){return A[left];}
//        int mid = left + (right - left) / 2;
//        int leftSum = Subarray(A,left,mid);// left part
//        int rightSum = Subarray(A,mid+1,right);//right part
//        int crossSum = crossSubarray(A,left,right);// cross part
//        if(leftSum >= rightSum && leftSum >= crossSum){// left part is max
//            return leftSum;
//        }
//        if(rightSum >= leftSum && rightSum >= crossSum){// right part is max
//            return rightSum;
//        }
//        return crossSum; // cross part is max
//    }
//    public int crossSubarray(int[] A,int left,int right){
//        int leftSum = Integer.MIN_VALUE;
//        int rightSum = Integer.MIN_VALUE;
//        int sum = 0;
//        int mid = left + (right - left) / 2;
//        for(int i = mid; i >= left ; i--){
//            sum = sum + A[i];
//            if(leftSum < sum){
//                leftSum = sum;
//            }
//        }
//        sum = 0;
//        for(int j = mid + 1; j <= right; j++){
//            sum = sum + A[j];
//            if(rightSum < sum){
//                rightSum = sum;
//            }
//        }
//        return leftSum + rightSum;
//    }
    public int crossSubarray(int[] nums,int left,int right) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = (left + right) / 2;
        for (int i = mid;i >= left;i--) {
            sum = sum + nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        for (int i = mid + 1;i <= right;i++) {
            sum = sum + nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
    public int findMaxSum(int[] nums,int left,int right) {
        if(left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftSum = findMaxSum(nums,left,mid);
        int rightSum = findMaxSum(nums,mid + 1,right);
        int crossSum = crossSubarray(nums,left,right);
        return Math.max(leftSum,Math.max(rightSum,crossSum));
    }

    public int maxSubArray(int[] nums) {
        return findMaxSum(nums,0,nums.length - 1);
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().maxSubArray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}