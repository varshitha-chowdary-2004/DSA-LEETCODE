class Solution {
    public int MaxSubset(int i,String[] strs, int m, int n,int[][][] dp ){
        if(i==strs.length){
            if(m<0||n<0) return Integer.MIN_VALUE;
            else return 0;
        }
        if(dp[i][m][n]!=-1) return dp[i][m][n];
        int skip = MaxSubset(i+1,strs,m,n,dp);
        int ones=0;
        int zeroes=0;
        for(int j=0;j<strs[i].length();j++){
            if(strs[i].charAt(j)=='0') zeroes++;
            else ones++;
        }
        if(m-zeroes<0 || n-ones<0) return dp[i][m][n] = skip;
        int pick = 1+ MaxSubset(i+1,strs,m-zeroes,n-ones,dp);
        return dp[i][m][n] = Math.max(skip,pick);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<=m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return MaxSubset(0,strs,m,n,dp);
    }
}