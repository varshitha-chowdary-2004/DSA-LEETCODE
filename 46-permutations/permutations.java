class Solution {
    public void backtrack(List<List<Integer>> result,List<Integer> perm,int[] arr){
        if(perm.size()==arr.length){
            result.add(new ArrayList(perm));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(perm.contains(arr[i])){
                continue;
            }
            perm.add(arr[i]);
            backtrack(result,perm,arr);
            perm.remove(perm.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums);
        return result;
        
    }
}