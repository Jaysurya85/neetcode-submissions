class Solution {
    public boolean possible(int k,int[] piles,int n, int h){
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += piles[i]/k + (piles[i]%k==0?0:1);
        }
        return ans<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int minK = 1;
        int maxK = 1;
        for(int i=0;i<n;i++){
            maxK = Math.max(maxK,piles[i]);
        }

        while(minK<maxK){
            int mid = minK + (maxK-minK)/2;
            if(possible(mid,piles,n,h)){
                maxK = mid;
            }
            else{
                minK = mid+1;
            }
        }
        return maxK;
    }
}
