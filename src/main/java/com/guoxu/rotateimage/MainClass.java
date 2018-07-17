//package com.guoxu.rotateimage;
//
//import net.sf.json.JSONArray;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class Solution {
//    public void rotate(int[][] matrix) {
//        for (int i = 0;i < matrix.length;i++) {
//            for (int j = 0;j < i;j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//        for (int i = 0;i < matrix.length;i++) {
//            for (int j = 0,k = matrix[i].length - 1;j <= k;j++,k--) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[i][k];
//                matrix[i][k] = temp;
//            }
//        }
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
//
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
//    public static String int2dArrayToString(int[][] array) {
//        if (array == null) {
//            return "null";
//        }
//        if (array.length == 0) {
//            return "[]";
//        }
//
//        StringBuilder sb = new StringBuilder("[");
//        for (int[] item : array) {
//            sb.append(Integer.toString(item));
//            sb.append(",");
//        }
//
//        sb.setCharAt(sb.length() - 1, ']');
//        return sb.toString();
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[][] matrix = stringToInt2dArray(line);
//
//            new Solution().rotate(matrix);
//            String out = int2dArrayToString(matrix);
//
//            System.out.print(out);
//        }
//    }
//}
