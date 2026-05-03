class Solution {

    public void update(int[][] grid, int i, int j, int val){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)return;
        if(grid[i][j]<val)return;
        grid[i][j] = Math.min(grid[i][j],val);
        update(grid,i+1,j,val+1);
        update(grid,i,j+1,val+1);
        update(grid,i-1,j,val+1);
        update(grid,i,j-1,val+1);
    }

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    update(grid,i,j,0);
                }
            }
        }
    }
}
