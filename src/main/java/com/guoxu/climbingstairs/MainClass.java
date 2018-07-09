package com.guoxu.climbingstairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3;i <= n;i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().climbStairs(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
