class Solution {
    int n = 0;
    public void findPaths(TreeNode root, int target,long s){
        if(root==null) return;
        if(root.left == null  && root.right == null){
            s+=root.val;
            if(target == s){
                n+=1;
            }
            return;
        }
        s+= root.val;
        if(target==s) n+=1;
        findPaths(root.left,target,s);
        findPaths(root.right,target,s);

    }
    public void paths(TreeNode root, int target,long s){
        if(root==null) return;
        findPaths(root,target,0);
        paths(root.left,target,0);
        paths(root.right,target,0);
    }
    public int pathSum(TreeNode root, int targetSum) {    
        long sum = 0;
        paths(root,targetSum,sum);
        return n;
    }
}