package com.guoxu.subarraysumequalsk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0;i < nums.length;i++) {
            int temp = k;
            for (int j = i;j >= 0;j--) {
                temp = temp - nums[j];
                if (temp == 0) {
                    res++;
                }
            }
        }
        return res;
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
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new Solution().subarraySum(nums, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
