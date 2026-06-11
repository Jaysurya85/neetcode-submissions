class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = static_cast<int>(prices.size());
        int min = prices[0];
        int current_max = prices[0];
        int ans = 0;
        for(int i=1;i<n;i++){
            if(prices[i]<current_max){
                ans += current_max - min;
                min = prices[i];
            }
            current_max = prices[i];
        }
        ans += current_max - min;
        return ans;
    }
};

