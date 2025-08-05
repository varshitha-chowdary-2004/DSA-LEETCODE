class Solution {
    public void bfs(int i,boolean[] vis,int[][] adj){
        int n = adj.length;
        Queue<Integer> q = new LinkedList<>();
        vis[i] = true;
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            for(int j=0;j<n;j++){
                if(adj[front][j]==1 && vis[j]==false){
                    vis[j]=true;
                    q.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        boolean vis[] = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,vis,adj);
                count++;
            }
        }
        return count;

    }
}