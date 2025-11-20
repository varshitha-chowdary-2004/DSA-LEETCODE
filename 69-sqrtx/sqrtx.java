class Solution {
    public int mySqrt(int n) {
    int res = 1;
    int l = 0 ,r = n;
    while(l<=r){
       long mid = (l+r)/2;
       if(mid*mid <=n){
        res = (int) mid;
        l = (int) mid+1;
       }else{
        r =(int) mid-1;
       }
    }
    return res;
    }
}