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
    public Boolean isBalanced(TreeNode root) {
        int[] result = maxDepth(root);
        return result[1] == 1 ? true : false;
    }

    public int[] maxDepth(TreeNode node){
        if(node == null){
            return new int[]{0,1};
        }
        int[] left = maxDepth(node.left);
        int[] right = maxDepth(node.right);
        if(left[1]==1 && right[1]==1 && Math.abs(left[0]-right[0])<=1){
            return new int[]{Math.max(left[0],right[0])+1,1};
        }
        return new int[]{0,0};
    }
}
