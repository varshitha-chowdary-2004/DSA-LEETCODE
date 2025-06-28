class Solution {
    public long los(int i,List<Integer> nums, int k,long[][] dp){
        if(i>=nums.size()){
            if(k==0) return 0;
            else return Long.MIN_VALUE;
        }
        if(dp[i][k]!=-1) return dp[i][k];
        long skip = los(i+1,nums,k,dp);
        if(k<nums.get(i)) return dp[i][k]=skip;
        
        long pick = los(i+1,nums,k-nums.get(i),dp);
        if(pick!=Long.MIN_VALUE) pick+=1;
        
        return dp[i][k]= Math.max(skip, pick);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        long[][] dp = new long[nums.size()][target+1];
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<target+1;j++){
                dp[i][j]=-1;
            }
        }
        long ans =  los(0,nums,target,dp);
        if(ans<=Long.MIN_VALUE) return -1;
        return (int) ans;
    }
}