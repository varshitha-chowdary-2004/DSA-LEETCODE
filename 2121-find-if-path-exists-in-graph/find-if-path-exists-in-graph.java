class Solution {
    public void bfs(int start,boolean[] vis,List<List<Integer>> adj,int end){
        Queue<Integer> q = new LinkedList<>();
        vis[start]= true;
        q.add(start);
        while(q.size()>0){
            int front = q.remove();
            for(int ele:adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]= true;
                    if(ele==end) return;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean vis[] = new boolean[n];
        bfs(start,vis,adj,end);
        return vis[end];
    }
}