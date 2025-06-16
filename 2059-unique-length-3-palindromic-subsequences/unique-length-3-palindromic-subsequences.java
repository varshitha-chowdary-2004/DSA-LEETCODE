class Solution {
   public int countPalindromicSubsequence(String s) {
        HashMap<Character,Integer> firstOcuur = new HashMap<>();
        HashMap<Character,Integer> lastOcuur = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!firstOcuur.containsKey(ch)){
                firstOcuur.put(ch,i);     
            }
            lastOcuur.put(ch,i);
        }
        int ans = 0;
        for(char ch:firstOcuur.keySet()){
            int i = firstOcuur.get(ch);
            int j = lastOcuur.get(ch);
            HashSet<Character> ss = new HashSet<>();
            if(i!=j){
                for(int k =i+1;k<j;k++){
                    ss.add(s.charAt(k));
                }
                
            }
            ans+=ss.size();
            
            
        }
        return ans;
    }
}