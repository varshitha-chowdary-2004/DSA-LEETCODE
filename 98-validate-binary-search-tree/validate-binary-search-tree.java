class Solution {
    TreeNode prev = null;

    public boolean inOrderTraversal(TreeNode root) {
        if (root == null) return true;

        // Traverse left subtree
        if (!inOrderTraversal(root.left)) return false;

        // Check current node value
        if (prev != null && root.val <= prev.val) return false;
        prev = root;  // update prev to current

        // Traverse right subtree
        return inOrderTraversal(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return inOrderTraversal(root);
    }
}
