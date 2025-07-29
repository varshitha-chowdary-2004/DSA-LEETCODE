class Solution {
    public void backtrack(List<List<Integer>> result,List<Integer> comb,int start,int end,int k){
        if(comb.size()==k){
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start;i<=end;i++){
            comb.add(i);
            backtrack(result,comb,i+1,end,k);
            comb.remove(comb.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),1,n,k);
        return result;
    }
}