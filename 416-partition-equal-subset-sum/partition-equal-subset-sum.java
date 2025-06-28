class Solution {
    /*public boolean subsetSum(int i,int[] arr,int k,int[][] dp){
        if(i<0) {
            if(k==0) return true;
            else return false;
        }
        boolean ans = false;
        if(dp[i][k] != -1) return (dp[i][k]==1);
        boolean skip = subsetSum(i-1,arr,k,dp);
        if(arr[i]>k) {
            dp[i][k] = (skip)?1:0;
            return skip;
        }
        boolean pick = subsetSum(i-1,arr,k-arr[i],dp);
        ans = skip||pick;
        dp[i][k] = (ans)?1:0;
        return ans;
    }*/
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2==1) return false;
        int[][] dp = new int[nums.length][sum/2 +1];
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<sum/2+1;j++){
                
                boolean skip = (i>0)?(dp[i-1][j]==1):(j==0);
                if(nums[i]>j) {
                    dp[i][j] = (skip)?1:0;
                }else{
                    boolean pick = (i>0)?(dp[i-1][j-nums[i]]==1):(j==0);
                    
                    dp[i][j] = (skip||pick)?1:0;
                }
                
            }
        }
        return dp[n-1][sum/2]==1;
    }
}