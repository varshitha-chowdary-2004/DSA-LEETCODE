class Solution {
    public boolean canFinish(int n, int[][] pre) {
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
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(q.size()>0){
            int ver = q.remove();
            ans.add(ver);
            for(int ele:adj.get(ver)){
                in[ele]--;
                if(in[ele]==0) q.add(ele);
            }
        }
        if(ans.size()==n) return true;
        else return false;
     
    }
}