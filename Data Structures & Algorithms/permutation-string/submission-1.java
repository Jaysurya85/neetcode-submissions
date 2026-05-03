class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Char =s1.toCharArray();
        Arrays.sort(s1Char);
        String sortedString  = Arrays.toString(s1Char);
        int n = s2.length();
        int k = s1.length();
        for(int i=0;i<n-k+1;i++){
            String temp = s2.substring(i,i+k);
            char[] tempChar = temp.toCharArray();
            Arrays.sort(tempChar);
            String sortedTemp  = Arrays.toString(tempChar);
            if(sortedTemp.equals(sortedString)){
                return true;
            }

        }
        return false;
    }
}
