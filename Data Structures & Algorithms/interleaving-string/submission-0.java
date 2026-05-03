class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(s3.length()!=n+m)return false;
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;

        for(int i=0;i<n;i++){
            if(s1.charAt(i)==s3.charAt(i) && dp[i][0])dp[i+1][0]=true;
        }
        for(int i=0;i<m;i++){
            if(s2.charAt(i)==s3.charAt(i) && dp[0][i])dp[0][i+1]=true;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(s1.charAt(i)==s3.charAt(i+j+1) && dp[i][j+1])dp[i+1][j+1]=true;
                if(s2.charAt(j)==s3.charAt(i+j+1) && dp[i+1][j])dp[i+1][j+1]=true;
            }
        }
        return dp[n][m];
    }
}
