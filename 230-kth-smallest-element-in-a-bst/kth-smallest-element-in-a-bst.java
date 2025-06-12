class Solution {
    static int r;
    static int ans;
    public void Inorder(TreeNode root, int k){
        if(root==null) return;
        Inorder(root.left,k);
        if(r==k) ans = root.val;
        r+=1;
        Inorder(root.right,k);
    } 
    public int kthSmallest(TreeNode root, int k) {
        r=1;
        Inorder(root,k);
        return ans;
    }
}