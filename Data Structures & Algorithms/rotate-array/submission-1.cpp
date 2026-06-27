class Solution {
public:
    void swap_array(vector<int>::iterator it1, vector<int>::iterator it2){
        while(it1<it2){
            swap(*it1,*it2);
            it1++;
            it2--;
        }
    }
    void rotate(vector<int>& nums, int k) {
        k = k%nums.size();
        swap_array(nums.begin(),nums.end()-1);
        swap_array(nums.begin(),nums.begin()+k-1);
        swap_array(nums.begin()+k,nums.end()-1);
    }
};