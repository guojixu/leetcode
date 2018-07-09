package com.guoxu.diameterofbinarytree;

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

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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
    private int diameter;

    /**
     * 方法二：参考leetcode方法解释，求深度的同时，算出diameter
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 1;
        depth(root);
        return diameter - 1;
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        diameter = Math.max(diameter,L + R + 1);
        return Math.max(L,R) + 1;
    }
}
//class Solution {
//    private int diameter = 0;
//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int temp = maxDepth(root.left) + maxDepth(root.right);
//        if (temp > diameter) {
//            diameter = temp;
//        }
//        diameterOfBinaryTree(root.left);
//        diameterOfBinaryTree(root.right);
//        return diameter;
//    }
//    public int maxDepth(TreeNode root) {
//        int leftDepth = 0;
//        int rightDepth = 0;
//        if (root == null) {
//            return 0;
//        }
//        leftDepth = 1 + maxDepth(root.left);
//        rightDepth = 1 + maxDepth(root.right);
//        if (leftDepth >= rightDepth){
//            return leftDepth;
//        } else {
//            return rightDepth;
//        }
//    }
//}

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Solution().diameterOfBinaryTree(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
