class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] ans = new long[nums.length];
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
            nums[i] +=max;
        }
        ans[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i] = nums[i]+ans[i-1];
        }
        return ans;
    }
}