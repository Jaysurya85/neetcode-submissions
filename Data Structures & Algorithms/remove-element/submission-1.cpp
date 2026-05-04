class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int left =0;
        int right = nums.size()-1;
        while(left<=right){
            if(nums[left] == val){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = nums[temp];
                right--;
            }
            else{
                left++;
            }
        }
        return right+1;
    }
};