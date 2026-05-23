class Solution {
public:
    bool isAnagram(string s, string t) {
        std::unordered_map<char,int> map;
        for(auto& ch: s){
            if(map.find(ch)==map.end())map[ch]=0;
            map[ch]++;
        }
        for(auto& ch:t){
            if(map.find(ch)==map.end())return false;
            if(map[ch]==0)return false;
            map[ch]--;
        }
        for(auto& pair: map){

            if(pair.second!=0)return false;
        }
        return true;
    }
};
