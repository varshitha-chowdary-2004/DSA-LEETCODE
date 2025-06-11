class Solution {
    public void inOrderTraversal(TreeNode root,List<Integer> arr){
        if(root==null) return;
        inOrderTraversal(root.left,arr);
        arr.add(root.val);
        inOrderTraversal(root.right,arr);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inOrderTraversal(root,arr);
        return arr.get(k-1);
    }
}