class Solution {
    public int firstOccurence(int[] nums,int target){
        int l=0,r = nums.length-1;
        int ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                ans = mid;
                r = mid-1;
            }else if(nums[mid]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }  
        }
        return ans;
    }
    public int lastOccurence(int[] nums,int target){
        int l=0,r = nums.length-1;
        int ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                ans = mid;
                l = mid+1;
            }else if(nums[mid]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }  
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = new int[2];
        ans[0] = firstOccurence(nums,target);
        ans[1] = lastOccurence(nums,target);
        return ans;
        
    }
}