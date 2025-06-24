class Solution {
    public int maxSatisfied(int[] arr, int[] grumpy, int k) {
        int i=0,j=k-1,maxun = 0,un =0,a=0,b=0,n = arr.length;
        for(int x=i;x<=j;x++){
            if(grumpy[x]==1) un+=arr[x];
        }
        while(j<n){
            if(maxun<un){
            maxun = un;
            a = i;
            b = j;
            }
            i++;j++;
            if(j<n && grumpy[j] ==1) un+=arr[j];
            if(grumpy[i-1]==1) un-=arr[i-1]; 
        }
        for(int c = a;c<=b;c++){
            grumpy[c] = 0;
        }
        int ans = 0;
        for(int c = 0;c<arr.length;c++){
            if(grumpy[c] == 0) ans+=arr[c];
        }
        return ans;

        
    }
}