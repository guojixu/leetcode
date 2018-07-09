package com.guoxu.besttimetobuyandsellstock;

import sun.rmi.server.InactiveGroupException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Solution {
    /**
     * 法二：找到低谷后最高的峰（参考leetcode解法），一趟即可
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0;i < prices.length;i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > ans) {
                ans = prices[i] - minPrice;
            }
        }
        return ans;
    }
}
//class Solution {
//    public int maxProfit(int[] prices) {
//        int ans = 0;
//        for (int i = 0;i < prices.length;i++) {
//            int profit = 0;
//            for(int j = i;j < prices.length;j++) {
//                if(prices[j] > prices[i]) {
//                    profit = Math.max(profit,prices[j] - prices[i]);
//                    ans = Math.max(ans,profit);
//                }
//            }
//        }
//        return ans;
//    }
//}

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
            int[] prices = stringToIntegerArray(line);

            int ret = new Solution().maxProfit(prices);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
