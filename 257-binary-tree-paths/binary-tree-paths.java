
class Solution {
    public void paths(TreeNode root,String s,List<String> ans){
        if(root==null) return;
        if(root.left ==null && root.right==null){
            s+=root.val;
            ans.add(s);
        }
        paths(root.left,s+root.val+"->",ans);
        paths(root.right,s+root.val+"->",ans);

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        paths(root,"",ans);
        return ans;
    }
}