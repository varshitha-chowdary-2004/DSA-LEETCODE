class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] in = new int[n];
        for(int i=0;i< pre.length;i++){
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
            in[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        int idx=0;
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(q.size()>0){
            int ver = q.remove();
            ans[idx++] = ver;
            for(int ele:adj.get(ver)){
                in[ele]--;
                if(in[ele]==0) q.add(ele);
            }
        }
        if(idx==n) return ans;
        else return new int[0];
     
    }
    
}