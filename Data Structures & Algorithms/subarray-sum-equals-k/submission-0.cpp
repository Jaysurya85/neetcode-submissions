class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int n = static_cast<int>(nums.size());
        
        vector<int> prefix_sum(n+1,0);
        unordered_map<int,int> prefix_map;


        for(int i=0;i<n;i++){
            prefix_sum[i+1] = prefix_sum[i] + nums[i];
        }
        int count = 0;
        for(int i=0;i<n;i++){
            prefix_map[prefix_sum[i]+k]++; 
            int sum = prefix_sum[i+1];
            if(prefix_map.find(sum)!=prefix_map.end()){
                count += prefix_map[sum];
            }
        }
        return count;
    }
};
