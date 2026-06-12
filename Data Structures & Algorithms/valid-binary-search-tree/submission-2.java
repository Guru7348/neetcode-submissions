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
    public boolean isValidBST(TreeNode root) {
        return validBST(root,-2000,2000);
    }

    public boolean validBST(TreeNode node,int low,int high){
        if(node == null){
            return true;
        }
        if( node.left!=null && (node.left.val>=node.val || node.left.val<=low)){
            return false;
        }
        if(node.right!=null && (node.right.val<=node.val || node.right.val >= high)){
            return false;
        }
        return validBST(node.left,low,node.val) && validBST(node.right,node.val,high);

    }
}
