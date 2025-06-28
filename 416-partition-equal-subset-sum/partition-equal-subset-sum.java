class Solution {
    public boolean subsetSum(int i,int[] arr,int k,int[][] dp){
        if(i>=arr.length) {
            if(k==0) return true;
            else return false;
        }
        boolean ans = false;
        if(dp[i][k] != -1) return (dp[i][k]==1);
        boolean skip = subsetSum(i+1,arr,k,dp);
        if(arr[i]>k) {
            dp[i][k] = (skip)?1:0;
            return skip;
        }
        boolean pick = subsetSum(i+1,arr,k-arr[i],dp);
        ans = skip||pick;
        dp[i][k] = (ans)?1:0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2==1) return false;
        int[][] dp = new int[nums.length][sum/2 +1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<sum/2+1;j++){
                dp[i][j] =-1;
            }
        }
        return subsetSum(0,nums,sum/2,dp);
        
    }
}