//package com.guoxu.findallanagramsinastring;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.List;
//
//class Solution {
//    public List<Integer> findAnagrams(String s, String p) {
//
//    }
//}
//
//public class MainClass {
//    public static String stringToString(String input) {
//        if (input == null) {
//            return "null";
//        }
////        return Json.value(input).toString();
//        return "flag";
//    }
//
//    public static String integerArrayListToString(List<Integer> nums, int length) {
//        if (length == 0) {
//            return "[]";
//        }
//
//        String result = "";
//        for(int index = 0; index < length; index++) {
//            Integer number = nums.get(index);
//            result += Integer.toString(number) + ", ";
//        }
//        return "[" + result.substring(0, result.length() - 2) + "]";
//    }
//
//    public static String integerArrayListToString(List<Integer> nums) {
//        return integerArrayListToString(nums, nums.size());
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);
//            line = in.readLine();
//            String p = stringToString(line);
//
//            List<Integer> ret = new Solution().findAnagrams(s, p);
//
//            String out = integerArrayListToString(ret);
//
//            System.out.print(out);
//        }
//    }
//}
