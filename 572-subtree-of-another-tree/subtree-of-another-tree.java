class Solution {
    public boolean sameTree(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        else if((p!=null && q==null) || (p==null && q!=null) || (p.val!=q.val)) return false;
        else{
            return sameTree(p.left,q.left) && sameTree(p.right,q.right);
        }

    }
    public void getSubRoot(TreeNode root, TreeNode subRoot,List<TreeNode> arr){
        if(root==null){ 
            return;
        } 
        if(root.val == subRoot.val){
            arr.add(root);
        } 
        getSubRoot(root.left,subRoot,arr);
        getSubRoot(root.right,subRoot,arr);
        return;   
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null && subRoot!=null) return false;
        if(root!=null && subRoot==null) return true;
        List<TreeNode> arr = new ArrayList<>();
        getSubRoot(root,subRoot,arr);
        boolean ans = false;
        for(TreeNode p : arr){
            boolean flag = sameTree(p,subRoot);
            if(flag == true) ans=true;
        } 
        return ans;
    }
}