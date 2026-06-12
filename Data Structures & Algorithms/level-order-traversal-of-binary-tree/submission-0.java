/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);

        traverse(currentLevel, result);

        return result;
    }

    private void traverse(List<TreeNode> nodes,
                          List<List<Integer>> result) {

        if (nodes.isEmpty()) {
            return;
        }

        List<Integer> level = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();

        for (TreeNode node : nodes) {

            level.add(node.val);

            if (node.left != null) {
                nextLevel.add(node.left);
            }

            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }

        result.add(level);

        traverse(nextLevel, result);
    }
}
