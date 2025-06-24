class Solution {
    public int maxSatisfied(int[] arr, int[] grumpy, int k) {
        int i=0,j=0,maxun = 0,un =0,a=0,b=0,n = arr.length;
        for(j=0;j<k;j++){
            if(grumpy[j]==1) un+=arr[j];
        }
        j--;
        if(maxun<un){
            maxun = un;
            a = i;
            b = j;
        }
        i++;j++;
        while(j<n){
            //un = un - arr[i-1] + arr[j];
            if(grumpy[i-1]==1) un-=arr[i-1];
            if(grumpy[j] ==1) un+=arr[j];
            if(maxun<un){
                maxun = un;
                a = i;
                b = j;
            }
            i++;j++;
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