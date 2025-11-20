class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // brute force
        int maxval = Arrays.stream(piles).max().getAsInt();
        int l = 1, r=maxval,ans = Integer.MAX_VALUE;
        while(l<=r){
            int mid = (l+r)/2;
            int total = 0;
            for(int i=0;i<piles.length;i++){
                total+=Math.ceil((double) piles[i]/mid);
                if(total>h) break;
            }
            if(total>h){
                l = mid+1;
            }else{
                r = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
}