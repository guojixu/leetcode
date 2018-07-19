package com.guoxu.houserobber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }else {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            dp[2] = Math.max(nums[0] + nums[2],nums[1]);
            for (int i = 3;i < nums.length;i++) {
                dp[i] = Math.max(dp[i - 2],dp[i - 3]) + nums[i];
            }
        }
        return Math.max(dp[nums.length - 1],dp[nums.length - 2]);
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

            int ret = new Solution().rob(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}