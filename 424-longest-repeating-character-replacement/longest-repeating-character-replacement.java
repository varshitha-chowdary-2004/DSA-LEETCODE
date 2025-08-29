class Solution {
    public int characterReplacement(String s, int k) {
        /*//bruteforce
        int maxlen =0;
        for(int i=0;i<s.length();i++){
            int[] freq = new int[26];
            int maxf=0;
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'A']++;
                maxf = Math.max(maxf,freq[s.charAt(j)-'A']);
                int chances = (j-i+1) - maxf;
                if(chances>k) break;
                else{
                    maxlen = Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
        */
        //better Approach
        int l=0,r=0,maxlen=0,maxf=0;
        int[] freq = new int[26];
        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            maxf = Math.max(maxf,freq[s.charAt(r)-'A']);
            int chances = (r-l+1) - maxf;
            if(chances<=k){
                maxlen = Math.max(maxlen,r-l+1);
            }else{
                if(chances>k){
                    freq[s.charAt(l)-'A']--;
                    l++;
                    chances = (r-l+1) - maxf;
                }   
            }
            r++;
        }
        return maxlen;
    }
}