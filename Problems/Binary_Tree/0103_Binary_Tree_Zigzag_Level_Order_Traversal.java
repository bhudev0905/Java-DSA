/**
 * Problem: 103. Binary Tree Zigzag Level Order Traversal
 * Difficulty: Medium
 * Topic: Binary Tree, DFS, BFS, Stack
 * Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Approach: Iterative using stack
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();

        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        boolean rightToLeft = false;
        int levelNo = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (rightToLeft)
                    level.addFirst(node.val);
                else
                    level.addLast(node.val);

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }

            ans.add(level);
            rightToLeft = !rightToLeft;
        }
        return ans;
    }
}