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
    public boolean check(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null)return true;
        if(root==null || subRoot==null)return false;
        if(root.val!=subRoot.val)return false;
        boolean leftCheck =check(root.left,subRoot.left); 
        boolean rightCheck =check(root.right,subRoot.right); 
        return leftCheck && rightCheck;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null)return true;
        if(root==null)return false;
        if(root.val==subRoot.val){
            System.out.println("root val is " + root.val + " subroot val is " + subRoot.val);
            boolean possible = check(root,subRoot);
            if(possible)return true;
        }
        boolean left = isSubtree(root.left,subRoot);
        boolean right = isSubtree(root.right,subRoot);
        return left | right;
    }
}
