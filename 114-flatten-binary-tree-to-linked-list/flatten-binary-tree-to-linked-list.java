
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        TreeNode lst = root.left;
        TreeNode rst = root.right;
        flatten(lst);
        flatten(rst);
        root.left = null;
        root.right = lst;
        TreeNode temp = root;
        if(temp==null) return;
        while(temp.right!=null){
            temp = temp.right;
        }
        temp.right = rst;
    }
}