class Solution {
    static int diff;
    static TreeNode prev;
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        if(prev != null){
            diff = Math.min(diff,root.val-prev.val);
        } prev = root;
        inorder(root.right);

    }
    public int minDiffInBST(TreeNode root) {
        diff = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return diff;
    }
}