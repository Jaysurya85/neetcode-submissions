class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];
        for(int i=3;i<=n+1;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-2],dp[i-2]+cost[i-3]);
        }
        return dp[n+1];

    }
}
