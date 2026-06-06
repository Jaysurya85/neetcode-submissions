class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = static_cast<int>(nums.size());
        vector<int> left_product(n+1,1); 
        int right_product = 1;
        vector<int> ans(n,1); 
        for(int i=0;i<n;i++){
            left_product[i+1] = left_product[i]*nums[i];
        }
        for(int i=n-1;i>0;i--){
            ans[i] = left_product[i]*right_product;
            right_product *= nums[i];
        }
        ans[0] = left_product[0]*right_product;
        return ans;
    }
};


