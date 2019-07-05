class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char number = board[i][j];
                if(number != '.'){
                    //hashset.add 如果已包含，有重复，返回false
                    //add 如果不包含，误重复，返回true
                    if(!set.add(number + "row is" + i)||   
                    !set.add(number + "column is" + j)||
                    !set.add(number + "sub boxes is " + i/3 + "-"+ j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}