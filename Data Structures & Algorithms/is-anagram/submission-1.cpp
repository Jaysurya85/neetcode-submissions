class Solution {
public:
    bool isAnagram(string s, string t) {
        std::vector<char> sVec(s.begin(), s.end());
        std::vector<char> tVec(t.begin(), t.end());
        sort(sVec.begin(), sVec.end());
        sort(tVec.begin(), tVec.end());
        return sVec==tVec;
    }
};
