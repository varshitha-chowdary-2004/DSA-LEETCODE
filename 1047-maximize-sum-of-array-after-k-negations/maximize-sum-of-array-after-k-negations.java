class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length && nums[i]<0 && k>0){
            nums[i]*=-1;
            k--;
            i++;
        }
        if(k%2==1){
            Arrays.sort(nums);
            nums[0]*=-1;
        }
        i=0;
        int sum =0;
        for(int s:nums){
            sum+=s;
        }
        return sum;
    }
}