class Solution {
    public long maximum(TreeNode root){
       if(root==null) return Long.MIN_VALUE;
       long a = root.val ,b=maximum(root.left),c=maximum(root.right);
       return Math.max(a,(Math.max(b,c)));
    }
    public long minimum(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
       long a = root.val ,b=minimum(root.left),c=minimum(root.right);
       return Math.min(a,(Math.min(b,c)));
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        
        if(root.val<=maximum(root.left)) return false;
        if(root.val>=minimum(root.right)) return false;
        return isValidBST(root.left) && isValidBST(root.right);

    }
}