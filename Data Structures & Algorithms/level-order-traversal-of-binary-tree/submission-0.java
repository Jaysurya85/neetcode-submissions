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
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(node==null)continue;

                temp.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(temp.isEmpty())continue;
            ans.add(temp);
        }
        return ans;
    }
}
