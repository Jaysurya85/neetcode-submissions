class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        Arrays.fill(dp[0],1);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int ans = 0;
                if(i>0)ans+=dp[i-1][j];
                if(j>0)ans+=dp[i][j-1];
                dp[i][j] = ans;
            }
        }
        return dp[n-1][m-1];
    }
}
