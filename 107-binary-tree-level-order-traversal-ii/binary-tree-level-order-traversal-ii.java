class Solution {
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public void levelWise(TreeNode root,List<List<Integer>> ans,int level){
        if(root==null) return;
        levelWise(root.left,ans,level-1);
        levelWise(root.right,ans,level-1);    
        ans.get(level).add(root.val);

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i = 0;i<lvl;i++){
            ans.add(new ArrayList<>());
        }
        levelWise(root,ans,lvl-1);
        return ans;
    }
}