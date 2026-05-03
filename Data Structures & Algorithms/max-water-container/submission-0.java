class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                ans = Math.max(ans,(j-i)*Math.min(heights[i],heights[j]));
            }
        }
        return ans;
    }
}
