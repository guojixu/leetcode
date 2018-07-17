//package com.guoxu.minimumpathsum;
//
//import net.sf.json.JSON;
//import net.sf.json.JSONArray;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class Solution {
//    public int minPathSum(int[][] grid) {
//        int m = grid.length,n = grid[0].length;
//        int tempSum = 0;
//        for (int i = 0;i < m;i++) {
//            tempSum = tempSum + grid[i][0];
//            grid[i][0] = tempSum;
//        }
//        tempSum = 0;
//        for (int i = 0;i < n;i++) {
//            tempSum = tempSum + grid[0][i];
//            grid[0][i] = tempSum;
//        }
//        for (int i = 1;i < m;i++) {
//            for (int j = 1;j < n;j++) {
//                grid[i][j] = Math.min(grid[i][j] + grid[i][j - 1],grid[i][j] + grid[i - 1][j]);
//            }
//        }
//        return grid[m - 1][n - 1];
//    }
//}
//
//public class MainClass {
//    public static int[] stringToIntegerArray(String input) {
//        input = input.trim();
//        input = input.substring(1, input.length() - 1);
//        if (input.length() == 0) {
//            return new int[0];
//        }
//
//        String[] parts = input.split(",");
//        int[] output = new int[parts.length];
//        for(int index = 0; index < parts.length; index++) {
//            String part = parts[index].trim();
//            output[index] = Integer.parseInt(part);
//        }
//        return output;
//    }
//
//    public static int[][] stringToInt2dArray(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//            return new int[0][0];
//        }
//
//        int[][] arr = new int[jsonArray.size()][];
//        for (int i = 0; i < arr.length; i++) {
//            JsonArray cols = jsonArray.get(i).asArray();
//            arr[i] = stringToIntegerArray(cols.toString());
//        }
//        return arr;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[][] grid = stringToInt2dArray(line);
//
//            int ret = new Solution().minPathSum(grid);
//
//            String out = String.valueOf(ret);
//
//            System.out.print(out);
//        }
//    }
//}
