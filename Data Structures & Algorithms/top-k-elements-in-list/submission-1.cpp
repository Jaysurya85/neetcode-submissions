class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> map;
        for(auto& num: nums){
            if(map.find(num)==map.end()){
                map[num] = 0;
            }
            map[num]++;
        }
        vector<pair<int,int>> num_pairs;
        for(auto& val: map){
            num_pairs.push_back({val.first, val.second});
        }

        sort(num_pairs.begin(), num_pairs.end(), [](auto& a,auto& b){
            return a.second>b.second;
        });
        vector<int> res;
        for(auto i=0;i<k && i<num_pairs.size();i++){
            res.push_back(num_pairs[i].first);
        }
        return res;
    }
};
