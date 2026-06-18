class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> set;
        int left =0;
        int right = 0;
        int ans = 0;
        int n = static_cast<int>(s.length());

        while(right<n){
            if(set.find(s[right])!=set.end()){
                set.erase(s[left]);
                left++;
            }
            else{
                set.insert(s[right]);
                right++;
                ans = max(ans,right-left);
            }
        }
        return ans;
    }
};
