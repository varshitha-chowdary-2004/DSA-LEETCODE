class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        for(int i=0;i<n;i+=2){
            if(nums[i]!=nums[(i+1)%n]) return nums[i];
        }
        return -1;
    }
}