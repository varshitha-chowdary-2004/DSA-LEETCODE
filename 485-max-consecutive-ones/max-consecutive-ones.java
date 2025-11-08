class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxcount =0;
        int l=0,r=0;
        while(r<nums.length){
            if(nums[r]==1) maxcount = Math.max(maxcount,r-l+1);
            else{
                l = r+1;
            }
            r++;
        }
        return maxcount;
    }
}