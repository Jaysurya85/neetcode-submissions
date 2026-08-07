class StockSpanner {
public:
    vector<pair<int,int>> s;
    int currentDay;
    StockSpanner():currentDay(0) {}
    
    int next(int price) {
        currentDay++;
        while(!s.empty() && s.back().first <= price){
            s.pop_back();
        }
        if(s.empty()){
            s.push_back({price,currentDay});
            return currentDay;
        }
        auto prev = s.back();
        s.push_back({price,currentDay});
        return currentDay - prev.second;


    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */