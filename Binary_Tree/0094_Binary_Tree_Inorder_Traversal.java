/*
 * Problem: 94. Binary Tree Inorder Traversal
 * Difficulty: Easy
 * Topic: Binary Tree, DFS, Stack
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * Approach: Iterative using stack
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> lst = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        if(root==null){
            return lst;
        }

        st.push(root);

        while(!st.isEmpty()){
           
            root = st.peek();
            if(root.left!=null && !visited.contains(root.left)){
                st.push(root.left);
                continue; 
            }

            TreeNode node = st.pop();
            visited.add(node);
            lst.add(node.val);

            if(node.right!=null){
                st.push(node.right);
            }
        }
        return lst;
    }
}