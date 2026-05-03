class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int current = 0;

        for(int i=0;i<nums.length;i++){
            current+=nums[i];
            ans =  Math.max(ans,current);
            current = Math.max(0,current);
        }
        return ans;
    }
}
