class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;     
        int[][] dp = new int[amount+1][n+1]; 
        Arrays.fill(dp[0],1);
        for(int i=1;i<amount+1;i++){
            for(int j=0;j<n;j++){
                dp[i][j+1] += dp[i][j];
                if(coins[j]<=i){
                    dp[i][j+1] += dp[i-coins[j]][j+1];
                }
            }
        }
        return dp[amount][n];
    }
}
