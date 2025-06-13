class Solution {
    public TreeNode constructBST(int[] preorder,int[] inorder,int plo,int phi,int inlo,int inhi){
        if(plo>phi || inlo>inhi) return null;
        TreeNode root = new TreeNode(preorder[plo]);
        int r =inlo;
        while(r <= inhi && inorder[r] != preorder[plo]) r++;
        int leftSize = r - inlo;
        root.left = constructBST(preorder,inorder,plo+1,plo+leftSize,inlo,r-1);
        root.right = constructBST(preorder,inorder,plo+leftSize+1,phi,r+1,inhi);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = Arrays.copyOf(preorder,n);
        Arrays.sort(inorder);
        
        return constructBST(preorder,inorder,0,n-1,0,n-1);
    }
}