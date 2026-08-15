/*
 * Problem: Weighted Sum of a Tree
 * Difficulty: Medium
 * Topic: Weekly Contest 514
 * Link: https://leetcode.com/problems/weighted-sum-of-a-tree/description/
 *
 * Approach: Build the tree from the parent array, calculate the depth of each node, and then compute the weighted sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;

        List<List<Integer>> children = new ArrayList<>();
        for(int i=0; i<n; i++){
            children.add(new ArrayList<>());
        }
        for(int i=1; i<n; i++){
            children.get(parent[i]).add(i);
        }

        int[] depth = new int[n];
        depth[0] = 1;
        int h = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int child : children.get(node)){
                depth[child] = depth[node] + 1;
                h = Math.max(depth[child], h);
                q.offer(child);
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long weight = (long) nums[i] * (h - depth[i] + 1);
            ans += weight;
        }
        return ans;
    }
}