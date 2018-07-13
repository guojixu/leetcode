package com.guoxu.topkfrequentelements;

import com.sun.corba.se.pept.transport.InboundConnectionCache;
import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.*;

class Solution {

//    public List<Integer> topKFrequent(int[] nums, int k) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int n: nums) {
//            map.put(n,0);
//        }
//        for (int n: nums) {
//            map.put(n,map.get(n) + 1);
//        }
//        TreeMap<Integer,List<Integer>> freqMap = new TreeMap<>();
//        for (int num : map.keySet()) {
//            int freq = map.get(num);
//            if (!freqMap.containsKey(freq)) {
//                freqMap.put(freq,new LinkedList<Integer>());
//            }
//            freqMap.get(freq).add(num);
//        }
//        List<Integer> res = new ArrayList<>();
//        while (res.size() < k) {
//            Map.Entry<Integer,List<Integer>> entry = freqMap.pollFirstEntry();
//            res.addAll(entry.getValue());
//        }
//        return res;
//    }
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int n: nums){
//            map.put(n, 0);
//        }
//        for (int n : nums) {
//            map.put(n,map.get(n)+1);
//        }
//
//        TreeMap<Integer,List<Integer>> freqMap = new TreeMap<>();
//        for (int num : map.keySet()){
//            int freq = map.get(num);
//            if (!freqMap.containsKey(freq)) {
//                freqMap.put(freq, new LinkedList<Integer>());
//            }
//            freqMap.get(freq).add(num);
//        }
//        List<Integer> res = new ArrayList<>();
//        while (res.size() < k) {
//            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
//            res.addAll(entry.getValue());
//        }
//        return res;
//    }
    public List<Integer> topKFrequent(int[] nums,int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n,0);
        }
        for (int n : nums) {
            map.put(n,map.get(n) + 1);
        }
        TreeMap<Integer,List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq,new LinkedList<Integer>());
            }
            freqMap.get(freq).add(num);
        }
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer,List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }

}

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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            List<Integer> ret = new Solution().topKFrequent(nums, k);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
