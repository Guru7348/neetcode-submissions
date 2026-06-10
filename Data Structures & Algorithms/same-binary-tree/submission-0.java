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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Integer[] resP = bfs(p);
        Integer[] resQ = bfs(q);
        if(resP.length != resQ.length){
            return false;
        }
        for(int i = 0;i<resP.length;i++){
            if(resP[i]!=resQ[i]){
                return false;
            }
        }
        return true;
    }

    public Integer[] bfs(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode n = queue.poll();
            if(n == null){
                result.add(null);
                continue;
            }else{
                result.add(n.val);
            }
            queue.add(n.left);
            queue.add(n.right);
        }
        return result.toArray(new Integer[0]);
    } 
}
