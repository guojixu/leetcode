package com.guoxu.Permutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public void permuteNums(int[] nums,int left) {
        if (left >= nums.length - 1) {
            List<Integer> result = new ArrayList<Integer>();
            for(int i = 0;i < nums.length;i++) {
                result.add(nums[i]);
            }
            ans.add(result);
        }
        else {
            for(int i = left;i < nums.length;i++) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                permuteNums(nums,left + 1);
                temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permuteNums(nums,0);
        return ans;
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Solution().permute(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
