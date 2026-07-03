class Solution {
public:

    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> ans;
        auto ind = lower_bound(arr.begin(),arr.end(),x);
        auto left = ind-1;
        auto right = ind;
        while(k>0 && left>=arr.begin() && right<arr.end()){
            if(abs(x-*left)<=abs(x-*right)){
                ans.push_back(*left);
                left--;
            }
            else{
                ans.push_back(*right);
                right++;
            }
            k--;
        }
        while(k>0 && left>=arr.begin()){
            ans.push_back(*left);
            left--;
            k--;
        }
        while(k>0 && right<arr.end()){
            ans.push_back(*right);
            right++;
            k--;
        }
        sort(ans.begin(),ans.end());
        return ans;
    }
};

