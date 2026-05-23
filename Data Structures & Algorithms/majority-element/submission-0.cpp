class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int,int> map;
        for(auto &num: nums){
            if(map.find(num)==map.end())map[num]=0;
            map[num]++;
        }
        int n = static_cast<int>(nums.size());
        for(auto &pair: map){
            if(pair.second>n/2){
                return pair.first;
            }
        }
        return -1;
    }
};