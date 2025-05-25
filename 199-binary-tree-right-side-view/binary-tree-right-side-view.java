class Solution {
    public void traversal(TreeNode root, int lvl, List<Integer> ans) {
        if (root == null) return;

        // Add the value only the first time we reach this level
        if (lvl == ans.size()) {
            ans.add(root.val);
        }

        // Visit right first, then left
        traversal(root.right, lvl + 1, ans);
        traversal(root.left, lvl + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, 0, ans);
        return ans;
    }
}
