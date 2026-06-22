class Solution {
public:
    string encode(vector<string>& strs) {
        if(strs.empty())return "";
        string output;
        string output_length;
        for(auto& str: strs){
            output+= str;
            output_length += to_string(str.length()) + ",";
        }
        cout << output_length + "#" + output << endl;
        return output_length + "#" + output;
    }

    vector<string> decode(string s) {
        if(s.empty())return {};
        vector<string> ans;
        vector<int> size;
        int i=0;
        while(s[i]!='#'){
            int j=i;
            while(s[j]!=','){
                j++;
            }
            size.push_back(stoi(s.substr(i,j-i)));
            i=j+1;
        }
        i++;
        for(auto sz: size){
            ans.push_back(s.substr(i,sz));
            i+=sz;
        }

        return ans;
    }
};
