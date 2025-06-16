class Solution {
   
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int rem = k - nums[i];
            if(map.containsKey(rem)){
                count++;
                int freq = map.get(rem);
                map.put(rem,freq-1);
                if(freq==1) map.remove(rem);
                
            }else{
                if(map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }
                else map.put(nums[i],1);
            }
        }  
        return count;

    }
}