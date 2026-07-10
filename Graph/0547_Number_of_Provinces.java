/*
 * Problem: 547. Number of Provinces
 * Difficulty: Medium
 * Topic: Principal, Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
 * Link: https://leetcode.com/problems/number-of-provinces/description/
 *
 * Approach: DFS traversal
 *
 * Time Complexity: O(V+E)
 * Space Complexity: O(N)
 */

class Solution {
    void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int vis[]) {
        vis[node] = 1;
        for (Integer it : adjList.get(node)) {
            if (vis[it] == 0)
                dfs(it, adjList, vis);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // convert adj matric to adj list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] vis = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adjList, vis);
            }

        }
        return count;
    }
}