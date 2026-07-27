/*
 * Problem: 733. Flood Fill
 * Difficulty: Easy
 * Topic: Principal, Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
 * Link: https://leetcode.com/problems/flood-fill/description/
 *
 * Approach: BFS traversal
 *
 * Time Complexity: O(M*N)
 * Space Complexity: O(M*N)
 */

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rows = image.length;
        int cols = image[0].length;

        int originalColor = image[sr][sc];

        // If the starting pixel already has the target color
        if (originalColor == color) {
            return image;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sr, sc));

        // Mark starting pixel as visited by changing its color
        image[sr][sc] = color;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            int row = current.row;
            int col = current.col;

            // Check all 4 neighbours
            for (int i = 0; i < 4; i++) {

                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    image[newRow][newCol] == originalColor) {

                    image[newRow][newCol] = color;
                    queue.offer(new Pair(newRow, newCol));
                }
            }
        }

        return image;
    }
}