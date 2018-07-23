package com.guoxu.groupanagrams;


import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] st = s.toCharArray();
            Arrays.sort(st);
            String key = String.valueOf(st);
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

public class MainClass {
}
