class Solution {
    public int rev(int n){
        int r=0;
        while(n>0){
            r = r*10+n%10;
            n/=10;
        }
        return r;
    }
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int val = nums[i]-rev(nums[i]);
            if(map.containsKey(val)){
                count+=map.get(val);
                count%=1000000007;
                map.put(val,map.get(val)+1);
            }
            else map.put(val,1);
        }
        return count;
    }
}