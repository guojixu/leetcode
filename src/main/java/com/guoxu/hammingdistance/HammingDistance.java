package com.guoxu.hammingdistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int distance = 0;
        for(int i = 0;i < 32;i++){
            distance += (z >> i) & 1;
        }
        return distance;
    }
}
public class HammingDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            line = in.readLine();
            int y = Integer.parseInt(line);

            int ret = new Solution().hammingDistance(x, y);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}