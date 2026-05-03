class Solution {

    public boolean doesExist(char[][] board, boolean[][] visited, String word, int current, int i, int j){
        if(current==word.length())return true;
        if(i<0 || j<0 || i==board.length || j==board[0].length)return false;
        if(visited[i][j])return false;
        boolean ans = false;
        if(board[i][j]==word.charAt(current)){
            visited[i][j]=true;
            ans |= doesExist(board,visited,word,current+1,i+1,j);
            ans |= doesExist(board,visited,word,current+1,i,j+1);
            ans |= doesExist(board,visited,word,current+1,i-1,j);
            ans |= doesExist(board,visited,word,current+1,i,j-1);
            visited[i][j]=false;
        }
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];    

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean exist = doesExist(board, visited, word, 0,i,j);
                    if(exist)return true;
                }
            }
        }
        return false;
    }
}
