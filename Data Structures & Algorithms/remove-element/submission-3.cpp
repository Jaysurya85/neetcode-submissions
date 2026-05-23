class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int left = -1;
        int right =static_cast<int>(nums.size()-1);
        while(left<right){
            if(nums[left+1]==val){
                swap(nums[left+1],nums[right]);
                // nums[left] = nums[left]^nums[right];
                // nums[right] = nums[left]^nums[right];
                // nums[left] = nums[left]^nums[right];
                right--;
            }
            else{
                left++;
            }
        }
        return left+1;
    }
};