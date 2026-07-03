class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = 0;
        int right = 0;
        int ans = nums.size()+2;
        int currentSum =0;
        while(right<nums.size()){
            if(currentSum<target){
                currentSum+=nums[right];
                right++;
            }
            else{
                ans = min(ans,right-left);
                currentSum -= nums[left];
                left++;
            }
        }
        while(left<=right && currentSum>=target){
            ans = min(ans,right-left);
            currentSum -= nums[left];
            left++;
        }
        if(ans==nums.size()+2)return 0;
        return ans;
    }
};