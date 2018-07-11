package com.guoxu.shortestunsortedcontinuoussubarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int start = sortedNums.length,end = 0;
        for (int i = 0;i < sortedNums.length;i++) {
            if (sortedNums[i] != nums[i]) {
                start = Math.min(start,i);
                end = Math.max(end,i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);

//        if (nums.length == 0 || nums.length == 1) {
//            return 0;
//        }
//        int left = 0,right = nums.length - 1;
//        while (left + 1 < nums.length && nums[left] < nums[left + 1]) {
//            left++;
//        }
//        System.out.println(left);
//        while (right - 1 >= 0 && nums[right] > nums[right - 1]) {
//            right--;
//        }
//        System.out.println(right);
//        if (left >= right) {
//            return 0;
//        } else {
//            return right - left + 1;
//        }
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

            int ret = new Solution().findUnsortedSubarray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
