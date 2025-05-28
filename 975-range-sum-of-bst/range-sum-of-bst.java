class Solution {  
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int sum = 0;
        if(root.val>low){
            sum+=rangeSumBST(root.left,low,high);
        }
        if(low<=root.val && high>=root.val){
            sum+=root.val;
        }
        if(root.val<high){
            sum+=rangeSumBST(root.right,low,high);
        }
        return sum;
  
        

        
    }
}