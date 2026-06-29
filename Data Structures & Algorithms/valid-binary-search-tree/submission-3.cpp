/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:

    bool isValid(TreeNode* node, int lower, int upper){
        if(node==nullptr)return true;
        if(node->val<=lower || node->val>=upper)return false;
        bool left = isValid(node->left, lower, node->val);
        bool right = isValid(node->right, node->val, upper);
        return left && right;
    }


    bool isValidBST(TreeNode* root) {
        return isValid(root, -1001, 1001);        
    }
};


