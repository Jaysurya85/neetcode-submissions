class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count = 0;
        int current = nums[0];
        for(auto& num:  nums){
            if(num==current)count++;
            else{
                count--;
            }
            if(count<0){
                count=1;
                current = num;
            }
        }
        return current;
    }
};