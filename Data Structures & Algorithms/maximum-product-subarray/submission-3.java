class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int temp = 1;
            for(int j=i;j<n;j++){
                temp*=nums[j];
                ans = Math.max(ans,temp);
            }
        }
        return ans;
    }
}
