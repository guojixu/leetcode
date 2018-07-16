package com.guoxu.targetsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    int result = 0;
    public void dfs(int[] nums,int S,int start) {
        if (S == 0 && start == nums.length) {
            result++;
        } else if (start < nums.length) {
            dfs(nums,S - nums[start],start + 1);
            dfs(nums,S + nums[start],start + 1);
        }

    }
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,S,0);
        return result;
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
            int S = Integer.parseInt(line);

            int ret = new Solution().findTargetSumWays(nums, S);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
