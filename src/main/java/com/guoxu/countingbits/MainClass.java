package com.guoxu.countingbits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
//    public int[] countBits(int num) {
//        int[] ans = new int[num + 1];
//        for (int i = 0;i <= num;i++) {
//            ans[i] = Integer.bitCount(i);
//        }
//        return ans;
//    }

    public int nearst(int n) {

        if (n < 2) {
            return 0;
        }
        int ans = 1;
        while (ans * 2 <= n) {
            ans = ans * 2;
        }
        return ans;
    }
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1;i <= num;i++) {
            ans[i] = ans[i - nearst(i)] + 1;
        }
        return ans;
    }
}

public class MainClass {
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            int[] ret = new Solution().countBits(num);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}