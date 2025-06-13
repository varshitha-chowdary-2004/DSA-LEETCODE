class Solution {
    static TreeNode prev;
    static boolean flag;
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        if(prev!=null && prev.val >= root.val){
            flag = false;
            return;
        } 
        prev = root;
        inOrder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        prev = null;
        flag = true;
        inOrder(root);
        return flag;

    }
}