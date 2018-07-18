//package com.guoxu.searcha2dmatrixII;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import com.sun.java.swing.plaf.windows.
//
//class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0 || matrix[0].length == 0) {
//            return false;
//        }
//        int i = 0,j = matrix[0].length - 1;
//        while (i < matrix.length && j >= 0) {
//            int x = matrix[i][j];
//            if (target == x) {
//                return true;
//            } else if (target < x) {
//                j--;
//            } else {
//                i++;
//            }
//        }
//        return false;
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
//    public static String booleanToString(boolean input) {
//        return input ? "True" : "False";
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[][] matrix = stringToInt2dArray(line);
//            line = in.readLine();
//            int target = Integer.parseInt(line);
//
//            boolean ret = new Solution().searchMatrix(matrix, target);
//
//            String out = booleanToString(ret);
//
//            System.out.print(out);
//        }
//    }
//}
