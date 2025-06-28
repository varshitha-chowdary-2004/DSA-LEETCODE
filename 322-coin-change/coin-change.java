class Solution {
    public long noOfCoins(int i,int[] coins, int k,long[][] dp) {
        if(i>=coins.length){
            if(k==0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][k]!=-1) return dp[i][k];
        long skip = noOfCoins(i+1,coins,k,dp);
        if(k<coins[i]) return dp[i][k] = skip;
        long pick = 1 + noOfCoins(i,coins,k-coins[i],dp);
        return dp[i][k] = Math.min(skip,pick);
    }
    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j]=-1;
            }
        }
         int ans = (int) noOfCoins(0,coins,amount,dp);
         if(ans==Integer.MAX_VALUE) return -1;
         return ans;
    }
}