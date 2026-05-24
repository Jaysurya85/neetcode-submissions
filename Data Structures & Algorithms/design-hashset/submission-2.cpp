class MyHashSet {
    private:
    array<int,32000> set;
    pair<int,int> convert_to_bit(int key){

        int ind = key/32;
        int bit = 1 << (key%32);
        cout << bit << " " << set[ind] << '\n';
        return {ind,bit};
    }
public:
    MyHashSet():set({}) {
    }
    
    void add(int key) {
        pair<int,int> pair1 = convert_to_bit(key);
        set[pair1.first] |= pair1.second;
    }
    
    void remove(int key) {
        pair<int,int> pair1 = convert_to_bit(key);
        if(!contains(key))return;
        set[pair1.first] ^= pair1.second;

    }
    
    bool contains(int key) {
        pair<int,int> pair1 = convert_to_bit(key);
        return pair1.second == (set[pair1.first]&pair1.second);
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */