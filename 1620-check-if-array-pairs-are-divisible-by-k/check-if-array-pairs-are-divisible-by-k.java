class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            int ele = arr[i]%k;
            if(ele<0) ele+=k;
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele,freq+1);
            }else{
                map.put(ele,1);
            }
        }
        if(map.containsKey(0)){
            if(map.get(0)%2!=0) return false;
            map.remove(0);
        }
        if(k%2==0 && map.containsKey(k/2)){
            if(map.get(k/2)%2!=0) return false;
            map.remove(k/2);
        }
        for(int ele :map.keySet()){
            int rem = k-ele;
            if(!map.containsKey(rem)) return false;
            int elefreq = map.get(ele);
            int remfreq = map.get(rem);
            if(elefreq!=remfreq) return false;
                
        }
        
        return true;
    }
}