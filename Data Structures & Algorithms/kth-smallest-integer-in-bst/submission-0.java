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
    public void findSmallest(TreeNode root, int k, int[] ans){
        if(root==null)return;
        
        findSmallest(root.left,k,ans);

        ans[0]++;
        if(ans[0]==k)ans[1]=root.val;

        findSmallest(root.right,k,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        findSmallest(root,k,ans);
        return ans[1];
    }
}
