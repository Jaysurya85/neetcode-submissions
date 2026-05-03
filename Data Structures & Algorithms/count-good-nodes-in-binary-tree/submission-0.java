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

    public int countGoodNodes(TreeNode root, int max){
        if(root==null)return 0;

        int ans = 0;
        if(root.val>=max){
            ans = 1;
        }

        int leftCount = countGoodNodes(root.left,Math.max(max,root.val)); 
        int rightCount = countGoodNodes(root.right,Math.max(max,root.val)); 
        return ans + leftCount + rightCount;
    }


    public int goodNodes(TreeNode root) {

        if(root==null)return 0;

        return countGoodNodes(root,root.val);
    }
}
