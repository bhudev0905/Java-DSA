/*
 * Problem: 130. Surrounded Regions
 * Difficulty: Medium
 * Topic: Principal, Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
 * Link: https://leetcode.com/problems/surrounded-regions/description/
 *
 * Approach: DFS traversal
 *
 * Time Complexity: O(M*N)
 * Space Complexity: O(M*N) {Recursion stack space}
 */

class Solution {
    private void dfs(int row, int col, boolean[][] vis, char[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        vis[row][col] = true;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !vis[nrow][ncol] && mat[nrow][ncol]=='O'){
                dfs(nrow, ncol, vis, mat);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        // for first row and last row
        for(int j=0; j<n; j++){
            if(!vis[0][j] && board[0][j]=='O'){
                dfs(0,j,vis,board);
            }
            if(!vis[m-1][j] && board[m-1][j]=='O'){
                dfs(m-1,j,vis,board);
            }
        }

        // for first column and last column
        for(int i=0; i<m; i++){
            if(!vis[i][0] && board[i][0]=='O'){
                dfs(i,0,vis,board);
            }
            if(!vis[i][n-1] && board[i][n-1]=='O'){
                dfs(i,n-1,vis,board);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}