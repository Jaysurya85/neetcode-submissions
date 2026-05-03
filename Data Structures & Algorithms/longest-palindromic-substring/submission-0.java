class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int maxLength = 0;
        int n = s.length();

        // find even
        for(int i=0;i<n-1;i++){
            int left = i;
            int right = i+1;
            while(s.charAt(left)==s.charAt(right)){
                if(right-left+1>maxLength){
                    ans = s.substring(left,right+1);
                    maxLength = right-left+1; 
                }

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
                if(right-left+1>maxLength){
                    ans = s.substring(left,right+1);
                    maxLength = right-left+1; 
                }
                if(left<=0 || right>=n-1)break;
                left--;
                right++;
            }
        }
        return ans;
    }
}
