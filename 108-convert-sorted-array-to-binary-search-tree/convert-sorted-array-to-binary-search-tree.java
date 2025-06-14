class Solution {
    public TreeNode construtBST(int[] nums,int lo,int hi){
        if(lo>hi) return null;
        int mid=(lo+hi)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construtBST(nums,lo,mid-1);
        root.right = construtBST(nums,mid+1,hi);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return construtBST(nums,0,n-1);
        
    }
}