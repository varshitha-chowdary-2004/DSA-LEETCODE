class Solution {
    public TreeNode helper(int[] postorder,int[] inorder,int polo,int pohi,int inlo,int inhi){
        if(inlo>inhi ||polo>pohi) return null;
        TreeNode root = new TreeNode(postorder[pohi]);
        int r=0;
        while(inorder[r]!=postorder[pohi]) r++;
        int leftsize = r-inlo;
        root.left = helper(postorder,inorder,polo,polo+leftsize-1,inlo,r-1);
        root.right = helper(postorder,inorder,polo+leftsize,pohi-1,r+1,inhi);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(postorder,inorder,0,n-1,0,n-1);
        
    }
}