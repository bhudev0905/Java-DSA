/*
 * Problem: 144. Binary Tree Preorder Traversal
 * Difficulty: Easy
 * Topic: Binary Tree, DFS, Stack
 * Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Approach: Iterative using stack
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        if(root==null) return list;
        
        s.push(root);
        
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            list.add(node.val);
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left);
        }
        return list;
    }
}