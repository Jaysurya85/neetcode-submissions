
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = static_cast<int>(nums.size());

        int red = 0;
        int blue = n-1;
        int i = 0;
        while(i<=blue){
            if(nums[i]==0){
                swap(nums[i],nums[red]);
                red++;
            }
            if(nums[i]==2){
                swap(nums[i],nums[blue]);
                blue--;
                i--;
            }
            i++;
        }
    }
};




