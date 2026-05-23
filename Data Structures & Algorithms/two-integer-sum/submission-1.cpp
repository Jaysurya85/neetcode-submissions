class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int,int> map;
        for(int i=0;i<static_cast<int>(nums.size());++i){
            int remaining = target - nums[i];
            if(map.find(remaining)==map.end()){
                map[nums[i]] = i;
                continue;
            }
            return {map[remaining], i};
        }
    }
};
