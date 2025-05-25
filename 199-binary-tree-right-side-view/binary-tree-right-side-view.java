class Solution {
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    public void traversal(TreeNode root,int lvl,List<Integer> ans){
        if(root==null) return;
        ans.set(lvl,root.val);
        traversal(root.left,lvl+1,ans);
        traversal(root.right,lvl+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        int n = levels(root);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(i,0);
        }
        traversal(root,0,ans);
        return ans;
    }
}