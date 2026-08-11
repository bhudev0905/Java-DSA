/*
 * Problem: 73. Set Matrix Zeroes
 * Difficulty: Medium
 * Topic: Array, Matrix
 * Link: https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * Approach: Brute Force
 *
 * Time Complexity: O(m*n)
 * Space Complexity: O(m+n)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // Brute
        int m = matrix.length, n = matrix[0].length;

        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // for rows
        for(int i=0; i<rows.size(); i++){
            int r = rows.get(i);
            for(int k=0; k<n; k++){
                matrix[r][k] = 0;
            }
        }
        // for columns
        for(int i=0; i<cols.size(); i++){
            int c = cols.get(i);
            for(int k=0; k<m; k++){
                matrix[k][c] = 0;
            }
        }

    }
}