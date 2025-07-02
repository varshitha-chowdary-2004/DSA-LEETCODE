class Solution {
    public int uniquePaths(int row,int col,Integer m,Integer n,int[][] dp,int[][] obstacleGrid){
        if(row>m || col>n || obstacleGrid[row][col] == 1) return 0;
        if(row==m && col==n) return 1;
        if(dp[row][col]!=-1) return dp[row][col]; 
        int rightways = uniquePaths(row,col+1,m,n,dp,obstacleGrid);
        int downways = uniquePaths(row+1,col,m,n,dp,obstacleGrid);
        return dp[row][col] = rightways + downways;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] =-1;
            }
        }
        return uniquePaths(0,0,m-1,n-1,dp,obstacleGrid);
    }
    

    
        
    

}