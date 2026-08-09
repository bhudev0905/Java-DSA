/*
 * Problem: Undirected Graph Cycle
 * Difficulty: Medium
 * Topic: DFS, Graph, union-find, Data Structures, Algorithms
 * Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 *
 * Approach: BFS traversal
 *
 * Time Complexity: 
 * Space Complexity: 
 */

class Solution {
	class Node {
		int first;
		int second;
		public Node(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, boolean vis[], int src) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(src, -1));
		vis[src] = true;
		
		while (!q.isEmpty()) {
			int node = q.peek().first;
			int par = q.peek().second;
			q.remove();
			
			for (Integer it: adj.get(node)) {
				if (vis[it] == false) {
					q.add(new Node(it, node));
					vis[it] = true;
				}
				
				else if (par != it)
					return true;
			}
		}
		return false;
	}
	
	public boolean isCycle(int V, int[][] edges) {
		// Code here
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i<edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		
		boolean vis[] = new boolean[V];
		Arrays.fill(vis, false);
		
		for (int i = 0; i<V; i++)
			if (vis[i] == false)
				if (checkForCycle(adj, vis, i))
					return true;
		
		return false;
		
	}
}
