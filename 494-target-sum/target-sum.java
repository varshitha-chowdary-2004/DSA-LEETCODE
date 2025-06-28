class Solution {
    public int ways(int i,int[] nums, int k){
        if(i>=nums.length){
            if(k==0) return 1;//valid way
            else return 0;
            
        }
        int add = ways(i+1,nums,k-nums[i]);
        int sub = ways(i+1,nums,k+nums[i]);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return ways(0,nums,target);
    }
}