class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for(int i=n-1;i>=0;i--){
            if(carry==0)break;
            if(digits[i]+carry>9){
                digits[i]=0;
            }
            else{
                digits[i]+=1;
                carry=0;
            }
        }
        if(carry==1){
            int[] ans = new int[n+1];
            ans[0] = 1;
            for(int i=1;i<=n;i++){
                ans[i] = digits[i-1];
            }
            return ans;
        }
        return digits;
    }
}
