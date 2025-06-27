//space optimisation on tabulation method of dp;
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int[] dp = new int[3];
        dp[0] =0;dp[1]=1;
        for(int i=1;i<n;i++){
            dp[2] = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}