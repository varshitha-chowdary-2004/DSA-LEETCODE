class Solution {
    public int minDays(int[] arr, int m, int k) {
        if(m*k > arr.length) return -1;
        int l = Arrays.stream(arr).min().getAsInt();
        int r = Arrays.stream(arr).max().getAsInt();
        int res =  -1;
        while(l<=r){
            int j = (l+r)/2;
            int count = 0, bc = 0;
            for(int i=0; i<arr.length;i++){
                if(arr[i]<=j){
                    count++;
                }else{
                    bc += (count/k);
                    count = 0;
                }
            }
            bc += (count/k);
            if(bc>=m){
                r=j-1;
                res = j;
            }else{
                l = j+1;
            }
        }
        return res;  
    }
}