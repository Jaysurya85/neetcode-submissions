class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        if(s.charAt(0)!='0')dp[1] = 1;
        for(int i=1;i<n;i++){
            int ans = 0;
            if(s.charAt(i)!='0')ans+= dp[i];
            if(s.charAt(i-1)!='0'){
                int no = (s.charAt(i-1) - '0')*10 + s.charAt(i) - '0';
                if(no<27)ans+=dp[i-1];
            }
            dp[i+1] = ans;
        }
        return dp[n];
    }
}
