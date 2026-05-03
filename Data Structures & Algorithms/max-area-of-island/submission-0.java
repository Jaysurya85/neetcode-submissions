class Solution {
    public int markAll(int[][] grid, boolean[][] visited,int i,int j){
        if(grid[i][j]==0)return 0;
        if(visited[i][j])return 0;
        visited[i][j]=true;
        int count = 1;
        if(i>0)count+=markAll(grid,visited,i-1,j);
        if(j>0)count+=markAll(grid,visited,i,j-1);
        if(i<grid.length-1)count+=markAll(grid,visited,i+1,j);
        if(j<grid[0].length-1)count+=markAll(grid,visited,i,j+1);
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0)continue;
                if(visited[i][j])continue;
                ans = Math.max(ans,markAll(grid,visited,i,j));
            }
        }
        return ans;
    }
}
