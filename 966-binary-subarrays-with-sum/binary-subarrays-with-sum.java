class Solution {
    public  int numSubarraysWithLessthanEqualSum(int[] nums, int k){
        if(k<0) return 0;
        int l=0,r=0,count=0,sum=0;
        while(r < nums.length){
            sum+=nums[r];   
            while(sum>k){
                sum-=nums[l];
                l++;
            }
            count+=(r-l+1);
            r++;

        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int k) {
        return numSubarraysWithLessthanEqualSum(nums,k)-numSubarraysWithLessthanEqualSum(nums,k-1);
    }
}