/*
 * Problem: 543. Diameter of Binary Tree
 * Difficulty: Easy
 * Topic: Binary Tree, DFS
 * Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Approach: Recursive
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    int diameter = 0;

    int height(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        height(root);

        return diameter;
    }
}