class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int i=0,j=0,sum=0,n=arr.length,minlen = Integer.MAX_VALUE; 
        while(j<n && sum<target){
            sum+=arr[j++];
            
        }
        j--;
        while(i<n && j<n){
            int len = j-i+1;
            if(sum>=target)minlen =  Math.min(minlen,len);
            sum-=arr[i];
            i++;
            j++;
            while(j<n && sum<target){
                sum+=arr[j++];
            }
            j--;
        }
        if(minlen == Integer.MAX_VALUE) return 0;
        return minlen;

        
    }
}