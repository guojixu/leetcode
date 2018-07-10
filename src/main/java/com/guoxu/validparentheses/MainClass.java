package com.guoxu.validparentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0;i < chars.length;i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            }
            if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if(chars[i] == ')' && c != '(') {
                    return false;
                }
                if(chars[i] == ']' && c != '[') {
                    return false;
                }
                if(chars[i] == '}' && c != '{') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            boolean ret = new Solution().isValid(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
