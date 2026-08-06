class Solution {
public:
    int calPoints(vector<string>& operations) {
        stack<int> s;
        for(const string& operation: operations){
            if(operation=="+"){
                int first = s.top();
                s.pop();
                int second = s.top();
                s.push(first);
                s.push(first+second);
            }
            else if(operation=="D"){
                int first = s.top();
                s.push(2*first);
            }
            else if(operation=="C"){
                s.pop();
            }
            else{
                int no = stoi(operation);
                s.push(no);
            }
        }
        int ans = 0;
        while(!s.empty()){
            ans += s.top();
            s.pop();
        }
        return ans;
    }
};