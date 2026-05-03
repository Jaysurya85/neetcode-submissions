class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n+1];
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(prices[i]>prices[j]){
                    if(j-1>0)dp[i+1] = Math.max(dp[i+1], prices[i]-prices[j] + dp[j-1]);
                    else dp[i+1] = Math.max(dp[i+1], prices[i]-prices[j]);
                }
                dp[i+1] = Math.max(dp[i+1],dp[i]);
            }
        }

        return dp[n];
    }
}
