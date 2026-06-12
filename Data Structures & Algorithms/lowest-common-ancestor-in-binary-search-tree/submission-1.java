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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode n = root;
        while(true){
            if(p.val>n.val && q.val>n.val){
                n = n.right;
            }
            else if(p.val<n.val && q.val < n.val){
                n= n.left;
            }else{
                break;
            }
        }
        return n;
    }
}
