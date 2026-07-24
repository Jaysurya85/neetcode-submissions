class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        stack<pair<int,int>> temp_stack;
        vector<int> ans(n);
        for(int i=n-1;i>=0;i--){
            while(!temp_stack.empty() && temp_stack.top().first<=temperatures[i])temp_stack.pop();
            if(!temp_stack.empty())ans[i] = temp_stack.top().second - i;
            temp_stack.push(make_pair(temperatures[i],i));
        }
        return ans;
    }
};
