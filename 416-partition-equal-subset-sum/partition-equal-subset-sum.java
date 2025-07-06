class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2==1) return false;
        int[][] dp = new int[nums.length][sum/2+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                boolean skip = (i>0)?(dp[i-1][j]==1):(j==0);
                if(nums[i]>j) dp[i][j] = (skip)?1:0;
                else{
                    boolean pick = (i>0)?(dp[i-1][j-nums[i]]==1):(j==0);
                    dp[i][j] = (pick||skip)?1:0;
                }
            }
        }
        return dp[nums.length-1][sum/2]==1;
    }
}