class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();

        // find even
        for(int i=0;i<n-1;i++){
            int left = i;
            int right = i+1;
            while(s.charAt(left)==s.charAt(right)){
                ans++;
                if(left<=0 || right>=n-1)break;
                left--;
                right++;
            }
        }
        // find odd
        for(int i=0;i<n;i++){
            int left = i;
            int right = i;
            while(s.charAt(left)==s.charAt(right)){
                ans++;
                if(left<=0 || right>=n-1)break;
                left--;
                right++;
            }
        }
        return ans;
    }
}
