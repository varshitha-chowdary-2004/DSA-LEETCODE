
class Solution {
    public boolean pathsum(TreeNode root,int s,int target){
        if(root==null) return false;
        if(root.left==null&& root.right == null){
            s+=root.val;
            if(s==target) return true;
        }
        boolean lst = pathsum(root.left,s+root.val,target);
        boolean rst = pathsum(root.right,s+root.val,target);
        return lst || rst;
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathsum(root,0,targetSum);  
    }
}