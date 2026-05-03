class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int ans = 0;

        for(int i=0;i<26;i++){
            char chr = (char)((int)'A' + i);
            int tempK = k;
            int left = 0;
            int right = 0;

            while(right<n){
                if(s.charAt(right)==chr)right++;
                else if(s.charAt(right)!=chr && tempK>0){
                    right++;
                    tempK--;
                }
                else if(s.charAt(left)==chr)left++;
                else {
                    left++;
                    tempK++;
                }
                ans = Math.max(ans,right-left); 
            }
        }
        return ans;
    }
}
