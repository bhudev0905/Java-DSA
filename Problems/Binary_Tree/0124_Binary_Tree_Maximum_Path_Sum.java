/*
 * Problem: 124. Binary Tree Maximum Path Sum
 * Difficulty: Hard
 * Topic: Binary Tree, DFS, Stack
 * Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Approach: Recursive
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    int maxi = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxi(root);
        return maxi;
    }

    int findMaxi(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, findMaxi(node.left));
        int right = Math.max(0, findMaxi(node.right));

        maxi = Math.max(left + right + node.val, maxi);

        return node.val + Math.max(left, right);
    }
}