class Solution {
public:
    int findMaxLength(unordered_set<int> nums, int start){
        int ans = 0;
        while(nums.find(start)!=nums.end()){
            start++;
            ans++;
        }
        return ans;
    }

    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> num_set;
        int ans = 0;
        for(auto& num: nums){
            num_set.insert(num);
        }    

        for(auto& num: num_set){
            if(num_set.find(num-1)!=num_set.end())continue;
            ans = max(ans,findMaxLength(num_set, num));
        }
        return ans;
    }
};
