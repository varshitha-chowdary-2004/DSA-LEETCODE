class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int i=0;
        int j=k-1;
        int count=0;
        int sum =0;
        for(int a=0;a<=j;a++){
            sum+=arr[a];
        }
        int avg = sum/k;
        if(avg>=threshold) count++;
        i++;
        j++;
        while(j<n){
            sum = sum - arr[i-1] + arr[j];
            avg = sum/k;
            if(avg>=threshold) count++;
            i++;
            j++;
        }
        return count;
    }
}