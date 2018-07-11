package com.guoxu.intersectionoftwolinkedlists;

/**-----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int i = 0,j = 0;
        ListNode p = headA;
        ListNode q = headB;
        while (p != null) {
            i++;
            p = p.next;
        }
        while (q != null) {
            j++;
            q = q.next;
        }
        int step = i - j;
        if (step >= 0) {
            p = headA;
            while(step != 0) {
                p = p.next;
                step--;
            }
            q = headB;
        } else {
            q = headB;
            while (step != 0)
            {
                q = q.next;
                step++;
            }
            p = headA;
        }
        ListNode intersectionNode = null;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        if (p != null)  {
            intersectionNode = p;
        }
        return intersectionNode;
    }
}
