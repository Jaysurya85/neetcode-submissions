class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int unique = 0;        
        int pointer = 1;
        int n = static_cast<int>(nums.size());
        while(pointer<n){
            if(nums[pointer]!=nums[unique]){
                nums[unique+1]=nums[pointer];
                unique++;
            }
            pointer++;
        }
        return unique+1;
    }
};


