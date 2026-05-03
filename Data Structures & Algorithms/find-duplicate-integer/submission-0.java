class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;


        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i])-1;
            if(nums[val]<0)return val+1;
            nums[val] = -nums[val];
        }
        return -1;
    }
}
