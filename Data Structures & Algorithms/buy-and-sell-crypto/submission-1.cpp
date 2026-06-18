class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0;
        int min_up_till_now = -INFINITY;
        for(auto &price: prices){
            min_up_till_now = min(min_up_till_now,price);
            ans = max(ans, price - min_up_till_now);
        }
        return ans;
    }
};
