package com.guoxu.subsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        List<Integer> tempAns = new ArrayList<>();
//        List<String> temp = new ArrayList<>();
//        int l = (int)Math.pow(2,nums.length);
//        for (int i = 0;i < l;i++) {
//            temp.add(Integer.toBinaryString(i));
//        }
//        for (int i = 0;i < temp.size();i++) {
//            for (int j = 0;j < temp.get(i).length();j++) {
//                if(temp.get(i).substring(j,j)== "1") {
//                    tempAns.add(nums[nums.length - 1 - i]);
//                }
//            }
//        }
//        for (int i = 0;i < temp.size();i++) {
//            System.out.println(temp.get(i));
//        }
//        return ans;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int l = (int)Math.pow(2,nums.length);
        for (int i = 0;i < l;i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0;j < nums.length;j++) {
                if (((i >> j) & 1) == 1) {
                    temp.add(nums[nums.length - 1 - j]);
                }
            }
            ans.add(temp);
        }
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

            List<List<Integer>> ret = new Solution().subsets(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}