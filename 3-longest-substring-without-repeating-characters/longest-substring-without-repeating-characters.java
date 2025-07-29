class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        for(int i=0;i<s.length();i++){
            int[] arr = new int[255];
            for(int j=i;j<s.length();j++){
                if(arr[s.charAt(j)]==1) break;
                int len = j-i+1;
                maxlen = Math.max(maxlen,len);
                arr[s.charAt(j)]=1;
            }
        }
        return maxlen;
    }
}