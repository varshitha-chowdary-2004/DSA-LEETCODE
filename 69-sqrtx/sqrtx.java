class Solution {
    public int mySqrt(int n) {
    long res = 1;
    while(res*res <= n){
        res++;
    }
    return (int)res-1;
    }
}