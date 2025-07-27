/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root){
        if(root==null) return 0;
        int left = pathSum(root.left);
        int right = pathSum(root.right);
        return root.val + Math.max(0,Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
        if(root==null) return Integer.MIN_VALUE;
        int l = pathSum(root.left);
        int r = pathSum(root.right);
        int mysum = root.val;
        if(l>0) mysum+=l;
        if(r>0) mysum+=r;
        int leftSum = maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);
        return Math.max(mysum,Math.max(leftSum,rightSum));
    }
}