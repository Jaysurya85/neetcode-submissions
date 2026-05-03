class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[amount+1][n+1];

        for(int i=0;i<=amount;i++){
            if(i==0)Arrays.fill(dp[i],0);
            else Arrays.fill(dp[i],Integer.MAX_VALUE);
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
        for(int i=0;i<=amount;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        if(dp[amount][n]>=Integer.MAX_VALUE)return -1;
        return (int)dp[amount][n];
    }
}
