class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> alphaMap = new HashMap<>();
        int ans =  0;
        int left = 0;
        int right=0;
        int n = s.length();
        while(right<n){
            char ch = s.charAt(right);
            alphaMap.put(ch,alphaMap.getOrDefault(ch,0)+1);
            while(left<right && alphaMap.get(ch)>1){
                alphaMap.put(s.charAt(left),alphaMap.get(s.charAt(left))-1);
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}