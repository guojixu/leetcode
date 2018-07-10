package com.guoxu.linkedlistcycle;


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
        next = null;
    }
}
 class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (slower == faster) {
                return true;
            }
        }
        return false;
    }
}
public class MainClass {
}
