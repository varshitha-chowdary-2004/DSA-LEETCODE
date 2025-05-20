
class Solution {
    public boolean exists(TreeNode root,TreeNode node){
        if(root==node) return true;
        if(root==null) return false;
        return exists(root.left,node) || exists(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) return root;
        boolean pLeftexists = exists(root.left,p);
        boolean qLeftexists = exists(root.left,q);
        if(pLeftexists && qLeftexists){
            return lowestCommonAncestor(root.left,p,q);
        }else if(!pLeftexists && !qLeftexists){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }    
    }
}