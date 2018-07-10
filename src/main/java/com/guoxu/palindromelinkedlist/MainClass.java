package com.guoxu.palindromelinkedlist;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

class Solution {
    /**
     * [-129,-129]错误
     */
//    boolean isPalindrome(ListNode head) {
//        List<Integer> v = new ArrayList<Integer>();
//        while(head != null) {
//            v.add(head.val);
//            head = head.next;
//        }
//        for (int i = 0,j = v.size() - 1;i < j;i++,j--) {
//            if(v.get(i) != v.get(j)) {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * [-129,-129]错误
     */
//    public boolean isPalindrome(ListNode head) {
//        ListNode p = head;
//        String str="";
//        while (p != null) {
//            str = str + p.val;
//            p = p.next;
//        }
//        return str.equals(new StringBuilder(str).reverse().toString());
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode q = head.next;
            head.next = null;
            ListNode r = null;
            while (q != null) {
                r = q.next;
                q.next = head;
                head = q;
                q = r;
            }
        }
        return head;
    }
    public boolean isPalindrome(ListNode head) {

        if (head  == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
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

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            boolean ret = new Solution().isPalindrome(head);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}