class Solution {
    public boolean isPalindrome(String s) {
        String finalString = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        System.out.println(finalString);
        int left =0;
        int right = finalString.length()-1;        
        while(left<right){
            if(finalString.charAt(left)!=finalString.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }
}
