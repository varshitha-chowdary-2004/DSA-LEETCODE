class Solution {
    public int totalFruit(int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int i=0,j=0,maxlen =0,n=arr.length;
        while(j<n){
            int ele = arr[j];
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele)+1);
            }else map.put(ele,1);
            
            if(map.size()>2){
                int freq = map.get(arr[i]);
                if(freq==1) map.remove(arr[i]);
                else map.put(arr[i],freq-1);
                i++;
            }

            int len = j-i+1;
            maxlen = Math.max(len,maxlen);
            j++;
        }
        
        return maxlen;
    }
}