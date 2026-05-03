class Solution {
    public void update(int[][] grid, int[][] rottenValue, int i, int j, int val){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)return;
        if(grid[i][j]==0)return;
        if(rottenValue[i][j]<val)return;
        rottenValue[i][j] = Math.min(rottenValue[i][j],val);
        update(grid,rottenValue,i+1,j,val+1);
        update(grid,rottenValue,i,j+1,val+1);
        update(grid,rottenValue,i-1,j,val+1);
        update(grid,rottenValue,i,j-1,val+1);
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] rottenValue = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val=Integer.MAX_VALUE;
                if(grid[i][j]==0)val = -1;
                else if(grid[i][j]==2) val =0;
                rottenValue[i][j]=val;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    update(grid,rottenValue,i,j,0);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rottenValue[i][j]==Integer.MAX_VALUE){
                    return -1;
                }
                ans = Math.max(ans,rottenValue[i][j]);
            }
        }
        return ans;
    }
}
