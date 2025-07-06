class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<amount+1;j++){
                int skip = (i>0)?dp[i-1][j]:((j==0)?0:Integer.MAX_VALUE);
                if(j<coins[i]) dp[i][j] = skip;
                else{
                    int pick = dp[i][j-coins[i]];
                    if(pick!=Integer.MAX_VALUE) pick+=1;
                    dp[i][j] = Math.min(skip,pick);
                }
            }
        }
         int ans = dp[coins.length-1][amount];
         if(ans==Integer.MAX_VALUE) return -1;
         return ans;
    }
}