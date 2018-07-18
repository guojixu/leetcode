package com.guoxu.kthlargestelementinanarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int partition(int[] nums,int low,int high) {
        int x = nums[high];
        int i = low - 1;
        for (int j = low;j <= high - 1;j++) {
            if (nums[j] >= x) {
                i = i + 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;
        return i;
    }
    public int kLargest(int[] nums,int low ,int high,int k) {
        if (low == high) {
            return nums[low];
        }
        int p = partition(nums,low,high);
        int q = p - low + 1;
        if (k == q) {
            return nums[p];
        } else if (k < q){
            return kLargest(nums,low,p - 1,k);
        } else {
            return kLargest(nums,p + 1,high,k - q);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        return kLargest(nums,0,nums.length - 1,k);
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new Solution().findKthLargest(nums, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
