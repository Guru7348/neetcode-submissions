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
    int maxPath = -2000;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(dfs(node.left),0);
        int right = Math.max(dfs(node.right),0);
        maxPath = Math.max(node.val+left+right,maxPath);
        return Math.max(left,right)+node.val;
    }
}
