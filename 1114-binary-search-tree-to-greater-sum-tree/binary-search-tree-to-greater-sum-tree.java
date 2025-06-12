class Solution {
    public void inOrder(TreeNode root,List<TreeNode> arr){
        if(root==null) return;
        inOrder(root.left,arr);
        arr.add(root);
        inOrder(root.right,arr);
         
    }
    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        inOrder(root,arr);
        int n = arr.size();
        for(int i = n-2;i>=0;i--){
            arr.get(i).val+=arr.get(i+1).val;
        }
        return root;
    }
}