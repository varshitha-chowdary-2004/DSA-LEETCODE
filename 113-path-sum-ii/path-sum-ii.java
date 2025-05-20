
class Solution {
    public void paths(TreeNode root, int target,List<List<Integer>> ans,List<Integer> arr,int s){
        if(root==null) return;
        if(root.left==null && root.right==null){
            s+=root.val;
            arr.add(root.val);
            if(s == target) ans.add(new ArrayList<>(arr));
            arr.remove(arr.size()-1);
            return;
        }
        arr.add(root.val);
        paths(root.left,target,ans,arr,s+root.val);
        paths(root.right,target,ans,arr,s+root.val);
        arr.remove(arr.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        paths(root,targetSum,ans,arr,0);
        return ans;
    }
}