class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int n = strs.size();
        int minSize = INT_MAX;
        for(int i=0;i<n;i++){
            minSize = std::min(minSize,(int)strs[i].length());
        }
        int ans = 0;
        while(ans<minSize){
            char first = strs[0][ans];
            bool possible = true;
            for(int i=1;i<n;i++){
                if(strs[i][ans]!=first){
                    possible = false;
                    break;
                }
            }
            if(!possible)break;
            ans++;
        }
        return strs[0].substr(0,ans);
    }
};