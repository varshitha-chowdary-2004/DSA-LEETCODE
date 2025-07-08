class Solution {
    public int lcs(int i,int j,StringBuilder a,StringBuilder b,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j] = 1+lcs(i-1,j-1,a,b,dp);
        else {
            return dp[i][j]= Math.max(lcs(i-1,j,a,b,dp),lcs(i,j-1,a,b,dp));
        }
    }
    public int minInsertions(String s) {
        StringBuilder a = new StringBuilder(s);
        StringBuilder b = new StringBuilder(a.reverse());
        a = a.reverse();    
        int m = a.length(), n = b.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        int lc = lcs(m-1,n-1,a,b,dp);
        return m - lc;
    }
}