
class Solution {
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1+ Math.max(levels(root.left),levels(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int mydia = levels(root.left)+levels(root.right);
        int leftdia = diameterOfBinaryTree(root.left);
        int rightdia = diameterOfBinaryTree(root.right);
        return Math.max(mydia,Math.max(leftdia,rightdia));
    }
}