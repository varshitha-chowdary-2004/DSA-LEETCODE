class Solution {
    public static class Pair implements Comparable<Pair>{
        int ele;
        int freq;
        Pair(int ele,int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if(this.freq==p.freq) return p.ele-this.ele;
            return this.freq - p.freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        int[] ans = new int[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:nums){
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele)+1);
            }else map.put(ele,1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int ele:map.keySet()){
            pq.add(new Pair(ele,map.get(ele)));
        }
        int idx = 0;
        while(pq.size()>0){
            Pair p = pq.remove();
            int n =p.freq;
            while(n>0){
                ans[idx++] = p.ele;
                n--;
            }
        }
        return ans;   
    }
}