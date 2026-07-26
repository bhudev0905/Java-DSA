class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];
        int[][] vis = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    queue.offer(new int[]{i,j,0});
                    vis[i][j] = 1;
                }else{
                    vis[i][j] = 0;
                }
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];
            
            ans[row][col] = steps;
            
            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0){
                    vis[nrow][ncol] = 1;
                    queue.add(new int[]{nrow, ncol, steps+1});
                }
            }
        }
        return ans;
    }
}