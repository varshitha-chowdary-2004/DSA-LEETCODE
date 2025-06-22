class Solution {
    public int subarraySum(int[] arr, int k) {
        int count = 0;
        for(int i=1;i<arr.length;i++){
            arr[i]+= arr[i-1];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int ele = arr[i];
            if(ele==k) count++;           
            int rem = ele-k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            
            if(map.containsKey(ele)) map.put(ele,map.get(ele)+1);
            else map.put(ele,1);
        }
        
        return count;
        
    }
}