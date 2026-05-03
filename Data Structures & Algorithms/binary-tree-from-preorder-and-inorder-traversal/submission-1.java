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
    int ind=0;
    public TreeNode createTree(int[] preorder, HashMap<Integer,Integer> map, int start,int end){
        if(start>end)return null;
        if(ind>=preorder.length)return null;

        TreeNode node = new TreeNode(preorder[ind++]);
        int mid = map.get(node.val);

        node.left = createTree(preorder, map,  start, mid-1);
        node.right = createTree(preorder, map,  mid+1, end);
        return node;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;

        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }

        TreeNode root = new TreeNode(preorder[ind++]);
        int mid = map.get(root.val);

        root.left = createTree(preorder,map,0,mid-1);
        root.right = createTree(preorder,map,mid+1,n-1);

        return root;
    }
}
