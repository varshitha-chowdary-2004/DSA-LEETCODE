class Solution {
    public int minCost(int[] cost,int idx,int n,int[] dp) {
        if(idx==n-1 || idx==n-2) return cost[idx];
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx] = cost[idx] + Math.min(minCost(cost,idx+1,n,dp),minCost(cost,idx+2,n,dp));

    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(minCost(cost,0,n,dp),minCost(cost,1,n,dp));
    }
}