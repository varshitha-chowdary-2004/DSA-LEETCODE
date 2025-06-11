class Solution {
    public void inOrderTraversal(TreeNode root,List<Integer> arr){
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp =root;
        while(true){
            if(temp!=null){
                st.add(temp);
                temp=temp.left;
            }else{
                if(st.size()==0) break;
                TreeNode top = st.pop();
                temp=top.right;
                arr.add(top.val);
            }
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inOrderTraversal(root,arr);
        return arr.get(k-1);
    }
}