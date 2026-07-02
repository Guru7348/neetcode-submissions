class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Map<Character,Boolean>> columns = new HashMap<>();
        Map<Integer,Map<Character,Boolean>> rows = new HashMap<>();
        Map<Integer,Map<Character,Boolean>> matrix = new HashMap<>();

        for(int i=0; i<board.length; i++){
            rows.put(i,new HashMap<>());
            columns.put(i,new HashMap<>());
            matrix.put(i,new HashMap<>());
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    if(!validate(i,j,rows,columns,matrix,board)){
                        return false;
                    };
                }
            }
        }
        return true;

    }

    private Boolean validate(int row,int column,Map<Integer,Map<Character,Boolean>> rows,Map<Integer,Map<Character,Boolean>> columns,Map<Integer,Map<Character,Boolean>> matrix,char[][] board){
        Character val = board[row][column];
        int matik = ((row/3)*3) + (column/3);
        if(rows.get(row).getOrDefault(val,false) || columns.get(column).getOrDefault(val,false) || matrix.get(matik).getOrDefault(val,false)){
            return false;
        }
        rows.get(row).put(val,true);
        columns.get(column).put(val,true);
        matrix.get(matik).put(val,true);
        return true;
    }
}
