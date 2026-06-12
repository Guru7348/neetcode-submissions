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
    int maxCount = 0;
    public int goodNodes(TreeNode root) {
        countNodes(root,root.val,root.val);
        return maxCount;
    }

    public void countNodes(TreeNode node,int maxVal,int rootVal){
        if(node == null){
            return ;
        }
        if(node.val >= maxVal ){
            maxCount+=1;
            maxVal = node.val;
        }
        countNodes(node.left,maxVal,rootVal);
        countNodes(node.right,maxVal,rootVal);
    }
}
