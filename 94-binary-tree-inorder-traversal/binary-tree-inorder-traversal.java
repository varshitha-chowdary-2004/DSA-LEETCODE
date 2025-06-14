class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left !=null){
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr) pred= pred.right;
                if(pred.right==null){
                    pred.right=curr;
                    curr = curr.left;
                }else{
                    ans.add(curr.val);
                    curr= curr.right;
                    pred.right = null;
                }
            }else{
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }
}