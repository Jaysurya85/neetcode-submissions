class Solution {
public:
    void reverseString(vector<char>& s) {
        int n = static_cast<int>(s.size());
        for(int i=0;i<n/2;i++){
            int temp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = temp;
        }
    }
};