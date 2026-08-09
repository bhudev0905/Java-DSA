/**
 * Problem: 100. Same Tree
 * Difficulty: Easy
 * Topic: Binary Tree, DFS, BFS, Stack
 * Link: https://leetcode.com/problems/same-tree/description/
 *
 * Approach: Recursive
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null && q==null) return false;
        if(p==null && q!=null) return false;
        if(p==null && q==null) return true;

        if(p.val != q.val) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        if(!left || !right) return false;

        return true;
    }
}