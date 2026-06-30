class MinStack {
public:
    vector<int> st;
    stack<int> min_st;
    MinStack() {
        
    }
    
    void push(int val) {
        st.push_back(val);
        if(min_st.empty()){
            min_st.push(val);
        }
        else{
            min_st.push(min(min_st.top(),val));
        }
    }
    
    void pop() {
        st.pop_back();
        min_st.pop();
        
    }
    
    int top() {
        return st.back();
    }
    
    int getMin() {
        return min_st.top();
    }
};
