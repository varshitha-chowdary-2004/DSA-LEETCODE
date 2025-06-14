class Solution {
    static int sum;
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.right);
        root.val+=sum;
        sum=root.val;
        inOrder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        sum=0;
        inOrder(root);
        return root;
    }
}