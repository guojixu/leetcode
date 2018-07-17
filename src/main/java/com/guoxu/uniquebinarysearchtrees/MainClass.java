package com.guoxu.uniquebinarysearchtrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        if (n < 1) {
            f[0] = 1;
        } else if (n < 2) {
            f[1] = 1;
        } else {
            f[0] = 1;
            f[1] = 1;
            f[2] = 0;
            for (int i = 2;i <= n;i++) {
                for (int j = 0;j < i;j++) {
                    f[i] += f[j] * f[i - j - 1];
                }
            }
        }
        return f[n];
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().numTrees(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
