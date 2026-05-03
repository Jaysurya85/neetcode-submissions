class Solution {
    public boolean wordb(String s, HashSet<String> wordDict) {
        if(s.length()==0)return true;
        boolean possible = false;
        for(int i=0;i<s.length();i++){
            if(wordDict.contains(s.substring(0,i+1))){
                possible |= wordb(s.substring(i+1),wordDict);
            }
        }
        return possible;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        HashSet<String> dict = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            dict.add(wordDict.get(i));
        }
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dict.contains(s.substring(j,i)) && dp[j]==true)dp[i]=true;
            }
        }
        return dp[n];
    }
}
