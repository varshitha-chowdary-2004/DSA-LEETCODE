class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        double cost;
        Pair(int node,double cost){
            this.node= node;
            this.cost = cost;
        }
        public int compareTo(Pair p){
            if(this.cost==p.cost) return this.node-p.node;
            return Double.compare(this.cost,p.cost);
        }
    }

    

    public double maxProbability(int V, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double cost = succProb[i];
            adj.get(u).add(new Pair(v,cost));
            adj.get(v).add(new Pair(u,cost));
        }
        double[] arr = new double[V+1];
        for(int i=0;i<=V;i++){
            arr[i] = 0;
        }
        arr[start_node] = 1;
        PriorityQueue<Pair> q =  new PriorityQueue<>(Collections.reverseOrder());
        q.add(new Pair(start_node,1));
        while(q.size()>0){
            Pair top = q.remove();
            int n = top.node;
            double c = top.cost;
            if(c<arr[n]) continue;
            for(Pair p:adj.get(n)){
                double t_c = p.cost*c;
                if(arr[p.node]< t_c){
                    arr[p.node] = t_c;
                    q.add(new Pair(p.node,t_c));
                }
            }
        }
        return arr[end_node];

    }
        
    
}