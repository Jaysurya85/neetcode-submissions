class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_set<int> set;
        
        int n = static_cast<int>(nums.size());


        for(int i=0;i<=k && i<n;i++){
            if(set.find(nums[i])!=set.end())return true;
            set.insert(nums[i]);
        }
        for(int i=k+1;i<n;i++){
            set.erase(nums[i-k-1]);
            if(set.find(nums[i])!=set.end())return true;
            set.insert(nums[i]);
        }
        return false;
    }
};