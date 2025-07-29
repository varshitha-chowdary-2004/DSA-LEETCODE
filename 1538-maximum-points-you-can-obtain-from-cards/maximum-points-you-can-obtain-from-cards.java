class Solution {
    public int maxScore(int[] nums, int k) {
        int lsum=0,rsum=0,maxsum=0;
        for(int i=0;i<k;i++){
            lsum+=nums[i];
        }
        maxsum=lsum;
        int ri = nums.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=nums[i];
            rsum+=nums[ri];
            ri--;
            maxsum=Math.max(maxsum,(lsum+rsum));
        }
        return maxsum;
    }
}