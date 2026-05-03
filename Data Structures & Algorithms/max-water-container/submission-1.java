class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            ans = Math.max(ans,(right-left)*Math.min(heights[left],heights[right]));
            if(heights[left]<heights[right])left++;
            else right--;
        }
        return ans;
    }
}
