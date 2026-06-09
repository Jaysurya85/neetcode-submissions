class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int n = strs.size();
        int ans = 0;
        while(ans<(int)strs[0].length()){
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