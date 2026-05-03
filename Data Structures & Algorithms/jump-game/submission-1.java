class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] can = new boolean[n];
        can[0]=true;
        for(int i=0;i<n;i++){
            if(can[i]){
                for(int j=1;j<=nums[i];j++){
                    if(i+j<n)can[i+j]=true;
                }
            }
        }
        return can[n-1];
    }
}
