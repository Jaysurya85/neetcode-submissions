class Solution {
public:
    bool isAnagram(string s, string t) {
        std::array<int,26> map;
        for(auto& ch: s){
            map[ch-'a']++;
        }
        for(auto& ch:t){
            if(map[ch-'a']==0)return false;
            map[ch-'a']--;
        }
        for(auto& val: map){
            if(val!=0)return false;
        }
        return true;
    }
};
