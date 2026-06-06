class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = static_cast<int>(nums.size());
        vector<int> ans(n,1); 
        int right_product = 1;
        for(int i=1;i<n;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }
        for(int i=n-1;i>=0;i--){
            ans[i] *= right_product;
            right_product *= nums[i];
        }
        return ans;
    }
};


