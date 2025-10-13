class Solution {
    public void rotate(int[] nums, int k) {
        
        
        int n = nums.length;
        if(n==0 || n==1) return;
        k = k%n;

        int[] temp = new int[nums.length];
        for(int i=n-k;i<n;i++){
            temp[i-n+k]= nums[i];
        }
        for(int i=0;i<=n-k-1;i++){
            temp[i+k] = nums[i];
        }
        for(int i=0;i<n;i++){
            nums[i] = temp[i];
        }
    }
}