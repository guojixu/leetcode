package com.guoxu.flattenbinarytreetolinkedlist;

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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
class Solution {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
//    private TreeNode pre = null;
//    public void flatten(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        pre = root;
//        TreeNode tempLeft = root.left;
//        TreeNode tempRight = root.right;
//        if (root.left != null) {
//            pre.right = root.left;
//        }
//        flatten(tempLeft);
//        flatten(tempRight);
//    }
//    public void flatten(TreeNode root) {
////        Stack<TreeNode> stack = new Stack<TreeNode>();
////        TreeNode p = root;
////        TreeNode pre = null;
////        while (p != null || !stack.isEmpty()) {
////            while (p != null) {
////                stack.push(p);
////                pre = p;
////                p = p.left;
////            }
////            if (!stack.isEmpty()) {
////                p = stack.pop();
////                p = p.right;
////            }
////        }
////    }
//    private TreeNode pre = null;
//
//    public void treeFlatten(TreeNode root,TreeNode pre) {
//        if (root == null) {
//            return;
//        }
//        TreeNode right = root.right;
//        TreeNode left = root.left;
//        if(pre != null) {
//            pre.right = root;
//            pre.left = null;
//        }
//        pre = root;
//        if (left != null) {
//            treeFlatten(left,pre);
//        }
//        if (right != null) {
//            treeFlatten(right,pre);
//        }
//    }
//    public void flatten(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        treeFlatten(root,pre);
//    }
}

public class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            new Solution().flatten(root);
            String out = treeNodeToString(root);

            System.out.print(out);
        }
    }
}
