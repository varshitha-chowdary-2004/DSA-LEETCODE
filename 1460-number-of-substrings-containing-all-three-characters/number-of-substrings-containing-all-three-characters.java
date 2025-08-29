class Solution {
    public int numberOfSubstrings(String s) {
        int count=0,n=s.length();
        /*for(int i=0;i<s.length();i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(!set.contains(s.charAt(j))) set.add(s.charAt(j));
                if(set.size()==3){
                    count+=(n-j);
                    break;
                }
            }
        }
        return count;*/
        int i=0;
        int[] lastseen = new int[3];
        Arrays.fill(lastseen,-1);
        while(i<n){
            lastseen[s.charAt(i)-'a'] = i;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                int minidx = Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2]));
                count += minidx+1;
            }
            i++;
        }
        return count;
    }
}