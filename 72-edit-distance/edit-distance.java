class Solution {
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int m = a.length(), n = b.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)== b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int del =  dp[i-1][j];
                    int ins =  dp[i][j-1] ;
                    int rep =  dp[i-1][j-1];
                    dp[i][j] = 1+ Math.min(del,Math.min(ins,rep));
                }
            }
        }
        return dp[m][n];
    }
}