class Solution {
    public static class Pair implements Comparable<Pair>{
        int ele ;
        int freq ;
        Pair(int ele,int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if(this.freq == p.freq) return this.ele - p.ele;
            return this.freq - p.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele)+1);

            }
            else{
                map.put(ele,1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int ele:map.keySet()){
            pq.add(new Pair(ele,map.get(ele)));
            if(pq.size()>k){
                pq.remove();
            }
        }
        for(int i=0;i<k;i++){
            Pair p = pq.remove();
            ans[i] = p.ele;
        }
        return ans;
        
    }
}