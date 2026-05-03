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
    public int[] findDiameter(TreeNode root){
        if(root==null)return new int[]{0,0};
        int[] leftSide = findDiameter(root.left);
        int[] rightSide = findDiameter(root.right);
        int maxIncludingMe = Math.max(leftSide[1],rightSide[1])+1;
        int max = Math.max(Math.max(leftSide[0],rightSide[0]),1+leftSide[1]+rightSide[1]);
        System.out.println("for root "+ root.val + " max including me is " + maxIncludingMe + " max is " + max);
        return new int[]{max,maxIncludingMe};
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = findDiameter(root);
        return ans[0]-1;
    }
}
