class Solution {
    public String minWindow(String s, String t) {
        /*//BruteForce
        int minlen = Integer.MAX_VALUE,sidx = -1;
        for(int i=0;i<s.length();i++){
            int[] freq = new int[256];
            for(int j=0;j<t.length();j++){
                freq[t.charAt(j)]++;
            }
            int count=0;
            for(int j=i;j<s.length();j++){
                if(freq[s.charAt(j)]>0) count++;
                freq[s.charAt(j)]--;
                if(count==t.length()){
                    if((j-i+1)< minlen){
                        minlen = j-i+1;
                        sidx = i;
                    }
                }
            }
        }
        if(sidx!=-1) return s.substring(sidx,sidx+minlen);
        else return "";
        */
        int minlen = Integer.MAX_VALUE, sidx = -1;
        int l=0,r=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int j=0;j<t.length();j++){
            map.put(t.charAt(j),map.getOrDefault(t.charAt(j),0)+1);
        }
        int count=0;
        while(r<s.length()){
            if(map.containsKey(s.charAt(r))){
                if(map.get(s.charAt(r))>0) count++;
            }
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)-1);
            while(count==t.length()){
                if((r-l+1)<minlen) {
                    minlen = r-l+1;
                    sidx = l;
                }
                map.put(s.charAt(l),map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0) count--;
                l++; 
            }
            r++;  
        }
        
        if(sidx!=-1) return s.substring(sidx,sidx+minlen);
        else return "";

    }
}