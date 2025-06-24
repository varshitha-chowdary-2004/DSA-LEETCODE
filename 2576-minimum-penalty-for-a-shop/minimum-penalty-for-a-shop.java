class Solution {
    public int bestClosingTime(String str) {
        int n = str.length();
        int[] pre = new int[n+1];
        int[] suf = new int[n+1];
        pre[0]=0;suf[n-1] =0;
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            pre[i+1] += pre[i];
            if(ch=='N') pre[i+1]+=1;
        }
        for(int i=n-1;i>=0;i--){
            char ch = str.charAt(i);
            suf[i] += suf[i+1] ;
            if(ch=='Y') suf[i]+=1;
        }
        int min = Integer.MAX_VALUE;
        int minidx = -1;
        for(int i=0;i<=n;i++){
            pre[i]=pre[i]+suf[i];
            if(min>pre[i]){
                minidx = i;
                min = pre[i];
            } 
        }
        return minidx;
    }
}