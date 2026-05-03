class Solution {
    public boolean checkIfTrue(int[] map){
        for(int i=0;i<map.length;i++){
            if(map[i]>0)return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];

        int n = s2.length();
        int k = s1.length();

        for(int i=0;i<k;i++){
            map[s1.charAt(i) - 'a']++;
        }

        for(int i=0;i<k;i++){
            if(i==n)break;
            map[s2.charAt(i) - 'a']--;
        }
        boolean ans = checkIfTrue(map);
        for(int i=0;i<n-k;i++){
            map[s2.charAt(i)- 'a']++;
            map[s2.charAt(i+k) - 'a']--;
            ans = ans | checkIfTrue(map);
            if(ans){
                break;
            }
        }
        return ans;
    }
}
