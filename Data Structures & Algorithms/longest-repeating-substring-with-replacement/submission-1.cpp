class Solution {
public:

    int replaceAndFindMax(const string &s, int k, int replace){
        int ans = 0;
        int start = 0;
        int end = 0;
        while(end<s.length()){
            if(s[end]==replace)end++;
            else{
                if(k>0){
                    k--;
                    end++;
                }
                else{
                    if(s[start]!=replace)k++;
                    start++;
                }
            }
            ans = max(ans,end-start);
        }
        return ans;
    }

    int characterReplacement(string s, int k) {
        int ans = 0;
        for(int i=0;i<26;i++){
            ans = max(ans,replaceAndFindMax(s,k,'A'+i));
        }
        return ans;
    }
};
