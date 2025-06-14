class Solution {
    public TreeNode iop(TreeNode root){
        TreeNode pred = root.left;
        while(pred.right!=null){
            pred = pred.right;
        }
        return pred;
    }
    public TreeNode parent(TreeNode root,TreeNode pred){
        if(root.left==pred) return root;
        TreeNode predparent = root.left;
        while(predparent.right!=pred){
            predparent = predparent.right;
        }
        return predparent;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        else if(root.val == key){
            if(root.left==null && root.right==null) return null;
            else if(root.left==null || root.right==null) {
                if(root.left==null) return root.right;
                else return root.left;
            }else{
                TreeNode pred = iop(root);
                TreeNode predparent = parent(root,pred);
                if(root==predparent){
                    pred.right = root.right;
                    return pred;
                }else{
                    predparent.right = pred.left;
                    pred.right = root.right;
                    pred.left = root.left;
                    return pred;
                }
            }
        }else if(root.val>key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;   
    }
}