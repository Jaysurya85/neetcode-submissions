class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];

        for(int i=0;i<=amount;i++){
            if(i==0)Arrays.fill(dp[i],0);
            else Arrays.fill(dp[i],amount+1);
        }
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(coins[j]>i){
                    dp[i][j+1] = dp[i][j];
                }
                else{
                    int remaining = i - coins[j];
                    dp[i][j+1] = Math.min(dp[i][j], 1+dp[remaining][j+1]);
                }
            }
        }
        if(dp[amount][n]>amount)return -1;
        return dp[amount][n];
    }
}
