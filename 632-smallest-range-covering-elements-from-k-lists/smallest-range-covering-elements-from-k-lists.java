class Solution {
    public class Triplet implements Comparable<Triplet>{
        int ele;
        int row;
        int col;
        Triplet(int ele,int row,int col){
            this.ele = ele;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Triplet t){
            return this.ele - t.ele;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int[] ans = {0,Integer.MAX_VALUE};
        int r = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            int ele = nums.get(i).get(0);
            pq.add(new Triplet(ele,i,0));
            if(ele>max) max = ele;
        }
        while(true){
            Triplet t = pq.remove();
            int range = max - t.ele;
            if(range<r){
                ans[0] = t.ele;
                ans[1] = max;
                r = range;
            }
            if(nums.get(t.row).size()-1==t.col) break;
            int newele = nums.get(t.row).get(t.col+1);
            if(newele>max) max = newele;
            pq.add(new Triplet(newele,t.row,t.col+1));
        }
        return ans;

    }
}