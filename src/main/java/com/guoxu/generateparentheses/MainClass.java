package com.guoxu.generateparentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> result = new ArrayList<>();
    private int num;
    public void dfs(int left,int right,String s) {
        if (left >= num && right >= num) {
            result.add(s);
            return;
        }
        if (left < num) {
            dfs(left + 1,right,s + "(");
        }
        if (right < left) {
            dfs(left,right + 1,s + ")");
        }
    }
    public List<String> generateParenthesis(int n) {
        String s = "";
        num = n;
        dfs(0,0,s);
        return result;
    }
}

public class MainClass {
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            List<String> ret = new Solution().generateParenthesis(n);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}
