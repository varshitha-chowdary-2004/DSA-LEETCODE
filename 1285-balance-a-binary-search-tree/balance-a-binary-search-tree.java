class Solution {
    public TreeNode constructBST(List<TreeNode> arr,int lo,int hi){
        if(lo>hi) return null;
        int mid = lo + (hi-lo)/2;
        TreeNode root = arr.get(mid);
        root.left = constructBST(arr,lo,mid-1);
        root.right = constructBST(arr,mid+1,hi);
        return root;
    }
    public void inOrder(TreeNode root,List<TreeNode> arr){
        if(root==null) return;
        inOrder(root.left,arr);
        arr.add(root);
        inOrder(root.right,arr);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        inOrder(root,arr);
        int n = arr.size();
        return constructBST(arr,0,n-1);
        

        
    }
}