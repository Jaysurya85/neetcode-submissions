class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int sz = 9;
        vector<vector<bool>> row_present(sz,vector<bool>(sz, false));
        vector<vector<bool>> col_present(sz,vector<bool>(sz, false));
        vector<vector<bool>> block_present(sz,vector<bool>(sz, false));


        for(int i=0;i<sz;i++){
            for(int j=0;j<sz;j++){
                if(board[i][j]=='.')continue;
                int block_row = i/3 + (j/3)*3;
                int ele = board[i][j]- '0' - 1;
                if ((row_present[i][ele]==true) ||  (col_present[j][ele]==true) || (block_present[block_row][ele]==true)){
                    cout << "because of i " << i << " and j " << j << " board[i][j] is " << board[i][j] << endl;
                    return false;
                }
                row_present[i][ele]=true;
                col_present[j][ele]=true;
                block_present[block_row][ele]=true;
            }
        }
        return true;
    }
};

