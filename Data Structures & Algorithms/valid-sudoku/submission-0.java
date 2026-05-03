class Solution {
    public boolean isValidSudoku(char[][] board) {
        int max = board.length;
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> cubes = new HashSet<>();

        // First check for rows
        for(int i=0;i<max;i++){
            for(int j=0;j<max;j++){
                if(board[i][j]=='.')continue;
                int val = (int)board[i][j];
                if(rows.contains(val))return false;
                rows.add(val);
            }
            rows = new HashSet<>();
        }

        // Check for cols
        for(int j=0;j<max;j++){ 
            for(int i=0;i<max;i++){
                if(board[i][j]=='.')continue;
                int val = (int)board[i][j];
                if(cols.contains(val))return false;
                cols.add(val);
            }
            cols = new HashSet<>();
        }
        // check for cubes
        for(int i=0;i<max;i+=3){
            for(int j=0;j<max;j+=3){
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        if(board[k][l]=='.')continue;
                        int val = (int)board[k][l];
                        if(cubes.contains(val))return false;
                        cubes.add(val);
                    }
                }
                cubes = new HashSet<>();
            }
        }

        return true;
    }
}
