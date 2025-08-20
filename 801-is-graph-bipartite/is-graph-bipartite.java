class Solution {
    public boolean bfs(int i,int[] vis,int[][] adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 0;
        while(q.size()>0){
            int v = q.remove();
            for(int ele:adj[v]){
                if(vis[ele]!=-1 && vis[v]==vis[ele]){
                    return false;
                }else if(vis[ele]==-1){
                    vis[ele] = (vis[v]==0)?1:0;
                    q.add(ele);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] adj) {
        int[] vis = new int[adj.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<adj.length;i++){
            if(vis[i]==-1){
                if(!bfs(i,vis,adj)) return false;
            }
        }
        return true;
        
    }
}