class Solution {

    public void markAll(char[][] grid, boolean[][] visited,int i,int j){
        if(grid[i][j]=='0')return;
        if(visited[i][j])return;
        visited[i][j]=true;
        if(i>0)markAll(grid,visited,i-1,j);
        if(j>0)markAll(grid,visited,i,j-1);
        if(i<grid.length-1)markAll(grid,visited,i+1,j);
        if(j<grid[0].length-1)markAll(grid,visited,i,j+1);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='0')continue;
                if(visited[i][j])continue;
                markAll(grid,visited,i,j);
                ans++;
            }
        }
        return ans;
    }
}
