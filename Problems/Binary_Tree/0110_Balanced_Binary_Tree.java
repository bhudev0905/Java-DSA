/*
 * Problem: 110. Balanced Binary Tree
 * Difficulty: Easy
 * Topic: Binary Tree, DFS, Stack
 * Link: https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * Approach: Recursive
 *
 * Time Complexity: O(n*n)
 * Space Complexity: O(1) 
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
      if(root == null){
        return true;
      }

      int leftHeight = height(root.left);
      int rightHeight = height(root.right);
      if(Math.abs( leftHeight - rightHeight ) > 1) return false;

      boolean left = isBalanced(root.left);
      boolean right = isBalanced(root.right);

      if(!left || !right) return false; 

      return true;
    }
    int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}