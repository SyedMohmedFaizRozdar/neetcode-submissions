class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for (int j=0; j< board[0].length; j++){
                if(helper(board,visited,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board,boolean[][] visited,String word,int row ,int col, int index){
        if(index >= word.length()) return true;
        if(row<0 || row >= board.length || col <0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) return false;
        visited[row][col] = true;
        boolean found = helper(board,visited,word,row-1,col,index+1) ||
            helper(board,visited,word,row,col-1,index+1) ||
            helper(board,visited,word,row+1,col,index+1) ||
            helper(board,visited,word,row,col+1,index+1);
        visited[row][col] = false;
        return found;
    }
}
