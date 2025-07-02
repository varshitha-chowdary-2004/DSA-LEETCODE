class Solution {
    public int pathSum(int i,int j,Integer m,Integer n,int[][] grid,int[][] dp){
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j] ;
        int right = pathSum(i,j+1,m,n,grid,dp);
        int down = pathSum(i+1,j,m,n,grid,dp);
        return dp[i][j] = grid[i][j] + Math.min(right,down);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length ,n =grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return pathSum(0,0,m,n,grid,dp);
    }
}