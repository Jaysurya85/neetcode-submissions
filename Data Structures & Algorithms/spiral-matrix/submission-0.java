class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int total = n*m;

        char direction = 'r';
        int i = 0;
        int j = 0; 

        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        while(total>0){
            if(!visited[i][j]){
                ans.add(matrix[i][j]);
                visited[i][j] =true;
                total--;
            }
            if(direction=='r' && (j+1>m-1 || visited[i][j+1])){
                direction='b';
            }
            else if(direction=='r'){
                j++;
            }
            else if(direction=='b' && (i+1>n-1 || visited[i+1][j])){
                direction='l';
            }
            else if(direction=='b'){
                i++;
            }
            else if(direction=='l' && (j-1<0 || visited[i][j-1])){
                direction='t';
            }
            else if(direction=='l'){
                j--;
            }
            else if(direction=='t' && (i-1<0 || visited[i-1][j])){
                direction='r';
            }
            else if(direction=='t'){
                i--;
            }
        }
        return ans;
    }
}
