class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int power = 31;
        for(int i=0;i<32;i++){
            int bit = n&1;
            System.out.print(bit + " ");
            if(bit==1){
                ans += (1<<power);
            }
            n = n>>1;
            power--;
        }
        return ans;

    }
}
