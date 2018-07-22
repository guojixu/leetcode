//package com.guoxu.decodestring;
//
//import org.apache.commons.lang.StringUtils;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class Solution {
//    private int pos = 0;
//    public String decodeString(String s) {
//        StringBuilder sb = new StringBuilder();
//        String num = "";
//        for (int i = pos;i < s.length();i++) {
//            if (s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))) {
//                sb.append(s.charAt(i));
//            } else if (Character.isDigit(s.charAt(i))) {
//                num += s.charAt(i);
//            } else if (s.charAt(i) == '[') {
//                pos = i + 1;
//                String next = decodeString(s);
//                for (int n = Integer.valueOf(num);n > 0;n--) {
//                    sb.append(next);
//                }
//                num = "";
//                i = pos;
//            } else if (s.charAt(i) == ']') {
//                pos = i;
//                return sb.toString();
//            }
//        }
//        return sb.toString();
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
//            String ret = new Solution().decodeString(s);
//
//            String out = (ret);
//
//            System.out.print(out);
//        }
//    }
//}
