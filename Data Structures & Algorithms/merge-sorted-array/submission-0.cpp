class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int len = n + m -1;        
        int r1 = m-1;
        int r2 = n-1;
        while(len>=0){
            if(r1<0){
                nums1[len]=nums2[r2];
                r2--;
            }
            else if(r2<0){
                break;
            }
            else if(nums1[r1]> nums2[r2]){
                nums1[len]=nums1[r1];
                r1--;
            }
            else{
                nums1[len]=nums2[r2];
                r2--;
            }
            len--;
        }
    }
};
