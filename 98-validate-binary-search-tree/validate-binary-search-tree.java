class Solution {
    public static boolean flag;
    public long maximum(TreeNode root){
       if(root==null) return Long.MIN_VALUE;
       long leftMax=maximum(root.left);
       if(leftMax >=root.val) flag = false;
       long rightMAx=maximum(root.right);
       return Math.max(root.val,Math.max(leftMax,rightMAx));
    }
    public long minimum(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
       long leftMin=minimum(root.left);
       long rightMin=minimum(root.right);
       if(rightMin <=root.val) flag = false;
       return Math.min(root.val,Math.min(leftMin,rightMin));
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        maximum(root);
        minimum(root);
        return flag;
        

    }
}
    