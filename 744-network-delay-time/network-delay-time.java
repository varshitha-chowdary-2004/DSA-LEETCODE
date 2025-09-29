class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int cost;
        Pair(int node,int cost){
            this.node= node;
            this.cost = cost;
        }
        public int compareTo(Pair p){
            return this.cost - p.cost;
        }
    }

    public int networkDelayTime(int[][] times, int V, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int cost = times[i][2];
            adj.get(u).add(new Pair(v,cost));
        }
        int[] arr = new int[V+1];
        for(int i=0;i<=V;i++){
            arr[i] = Integer.MAX_VALUE;
        }
        arr[src] = 0;
        PriorityQueue<Pair> q =  new PriorityQueue<>();
        q.add(new Pair(src,0));
        
        while(q.size()>0){
            Pair top = q.remove();
            int n = top.node;
            int c = top.cost;
            if(c>arr[n]) continue;
            for(Pair p:adj.get(n)){
                int t_c = p.cost+c;
                if(arr[p.node]> t_c){
                    arr[p.node] = t_c;
                    
                    q.add(new Pair(p.node,t_c));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= V; i++) {
            if (arr[i] == Integer.MAX_VALUE) return -1; // unreachable node
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}