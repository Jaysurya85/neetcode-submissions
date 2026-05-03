class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n!=m)return false;

        char [] charS = s.toCharArray();
        char [] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        for(int i=0;i<n;i++){
            if(charS[i]!=charT[i])return false;
        }
        return true;
    }
}
