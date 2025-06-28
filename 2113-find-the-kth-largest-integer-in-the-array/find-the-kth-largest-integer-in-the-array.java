class Solution {
    public class  Pair implements Comparable<Pair>{
        String ele;
        
        Pair(String ele){
            this.ele = ele;
            
        }
        public int compareTo(Pair p){
            if (this.ele.length() != p.ele.length()) {
                return this.ele.length() - p.ele.length();
            }
            return this.ele.compareTo(p.ele);
        }
    }
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        for(String ele:nums){
            pq.add(new Pair(ele));
            while(pq.size()>k) pq.remove(); 
        }
        
        Pair ans = pq.peek();
        return ans.ele;
    }
}