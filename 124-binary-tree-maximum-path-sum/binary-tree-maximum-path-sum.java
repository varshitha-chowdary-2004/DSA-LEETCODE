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
    public static int maxsum;
    public int lineSum(TreeNode root){
        if(root==null) return 0;
        int l = lineSum(root.left);
        int r = lineSum(root.right);
        int pathsum = root.val;
        if(l>0) pathsum+=l;
        if(r>0) pathsum+=r;
        maxsum = Math.max(maxsum,pathsum);
        return root.val + Math.max(0,Math.max(l,r));
    }
    public int maxPathSum(TreeNode root) {
        maxsum =Integer.MIN_VALUE;
        lineSum(root);
        return maxsum;
    }
}