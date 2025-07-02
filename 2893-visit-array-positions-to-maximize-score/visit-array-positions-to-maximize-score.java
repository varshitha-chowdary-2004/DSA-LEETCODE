class Solution {
    public long Score(int i,int[] nums,int prev,Integer x,long[][] dp ){
        if(i>=nums.length) {
            return 0;
        }
        int parity = nums[i]%2;
        if(dp[prev][i] != -1) return dp[prev][i];
        long skip = Score(i+1,nums,prev,x,dp);
        long pick;
        if(parity ==prev ) {
            pick = nums[i]+Score(i+1,nums,parity,x,dp);
        }else{
            pick = nums[i]-x + Score(i+1,nums,parity,x,dp);
        }
        return dp[prev][i] = Math.max(pick,skip);
        
    }
    public long maxScore(int[] nums, int x) {
        long[][] dp = new long[2][nums.length];
        for(int i=0;i<2;i++){
            for(int j=0;j<nums.length;j++){
                dp[i][j] = -1;
            }
        }
        int firstParity = nums[0] % 2;
        return nums[0] + Score(1, nums, firstParity, x, dp);
    }
}