class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,vector<string>> map;
        for(auto &str: strs){
            string copy = str;
            sort(copy.begin(),copy.end());
            if(map.find(copy)==map.end())map[copy]={};
            map[copy].push_back(str);
        }
        vector<vector<string>> result;
        for(auto &pair: map){
            result.push_back(pair.second);
        } 
        return result;
    }
};
