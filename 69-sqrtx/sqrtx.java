class Solution {
    public int mySqrt(int n) {
    
    int l = 0 ,r = n;
    while(l<=r){
       long mid = (l+r)/2;
       if(mid*mid <=n){
        l = (int) mid+1;
       }else{
        r =(int) mid-1;
       }
    }
    return r;
    }
}