class Solution {

    public void fillWithWater(int i , int j, int currentHeight, int[][] heights, int[][] pacific){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length)return;
        if(pacific[i][j]==1)return;
        if(heights[i][j]<currentHeight)return;
        pacific[i][j]=1;
        fillWithWater(i+1,j,heights[i][j],heights,pacific);
        fillWithWater(i-1,j,heights[i][j],heights,pacific);
        fillWithWater(i,j+1,heights[i][j],heights,pacific);
        fillWithWater(i,j-1,heights[i][j],heights,pacific);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pacific[i][j] = -1;
                atlantic[i][j] = -1;
                if(i==0 || j==0){
                    pacific[i][j]++;
                }
                if(i==n-1 || j==m-1){
                    atlantic[i][j]++;
                } 
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j]==0){
                    fillWithWater(i,j,heights[i][j],heights, pacific);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atlantic[i][j]==0){
                    fillWithWater(i,j,heights[i][j],heights, atlantic);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return ans;
    }
}
