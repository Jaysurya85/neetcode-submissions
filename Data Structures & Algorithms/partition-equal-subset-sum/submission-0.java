class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            sum += nums[i];
        }

        if(sum%2!=0)return false;
        sum /=2;

        boolean[][] dp = new boolean[sum+1][n+1];
        
        Arrays.fill(dp[0], true);
        for(int i=1;i<sum+1;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j])dp[i][j+1]=true;
                else if(nums[j]>i)dp[i][j+1]=false;
                else{
                    dp[i][j+1] = dp[i-nums[j]][j];
                }
            }
        }
        return dp[sum][n];
    }
}
