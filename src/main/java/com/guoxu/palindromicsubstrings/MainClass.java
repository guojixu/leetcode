//package com.guoxu.palindromicsubstrings;
//
//import net.sf.json.JSON;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class Solution {
//    private int count = 0;
//    public void helper(String s,int left,int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            count++;
//            left--;
//            right++;
//        }
//    }
//    public int countSubstrings(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        for (int i = 0;i < s.length();i++) {
//            helper(s,i,i);
//            helper(s,i,i + 1);
//        }
//        return count;
//    }
//}
//
//public class MainClass {
//    public static String stringToString(String input) {
//        if (input == null) {
//            return "null";
//        }
//        return Json.value(input).toString();
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);
//
//            int ret = new Solution().countSubstrings(s);
//
//            String out = String.valueOf(ret);
//
//            System.out.print(out);
//        }
//    }
//}
