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
    public List<Integer> rightSideView(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            int rightMost = -1;

            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(node==null)continue;

                rightMost = node.val;
                queue.add(node.left);
                queue.add(node.right);
            }
            if(rightMost==-1)continue;
            ans.add(rightMost);
        }
        return ans; 
    }
}
