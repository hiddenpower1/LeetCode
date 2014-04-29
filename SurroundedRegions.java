import java.util.ArrayList;


public class SurroundedRegions {
  public void solve(char[][] board) {
    if(board.length==0 || board[0].length == 0){
      return;
    }
    
    for(int i=0;i<board.length;i++){
      if(board[i][0] == 'O' ){
        //newBoard[i][0] = 'O';
        dfs(board, i,0);
      }
      if(board[i][board[0].length-1] == 'O'){
        //newBoard[i][0] = 'O';
        dfs(board,i,board[0].length-1);
      }
    }
    
    for(int j=1;j<board[0].length-1;j++){
      if(board[0][j] == 'O'){
        //newBoard[i][0] = 'O';
        dfs(board,0,j);
      }
      if(board[board.length-1][j] == 'O'){
        //newBoard[i][0] = 'O';
        dfs(board,board.length-1,j);
      }
    }
    
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[0].length; j++) {
          if (board[i][j] == 'O') {
              board[i][j] = 'X';
          }
          if (board[i][j] == 'Y') {
              board[i][j] = 'O';
          }

      }
    }
    
  }
  
  private void dfs(char[][] board, int i, int j) {
    // TODO Auto-generated method stub
    int rows = board.length;
    int columns = board[0].length;

    if (i >= 0 && i < rows && j >= 0 && j < columns && board[i][j] == 'O') {
        board[i][j] = 'Y';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
    
  }
  
  private void bfs(char[][] board, int i, int j) {
    // TODO Auto-generated method stub
    int rows = board.length;
    int columns = board[0].length;

    ArrayList<int[]> cur = new ArrayList<int[]>();
    ArrayList<int[]> next = new ArrayList<int[]>();
    int[] pos = {i,j};
    cur.add(pos);
    
    while(!cur.isEmpty()){
      for(int m=0;m<cur.size();m++){
        int x = cur.get(m)[0];
        int y = cur.get(m)[1];
        board[x][y] = 'Y';
        fill(x - 1, y, next, board, rows, columns);
        fill(x + 1, y, next, board, rows, columns);
        fill(x, y - 1, next, board, rows, columns);
        fill(x, y + 1, next, board, rows, columns);
      }
      
      ArrayList<int[]> temp = cur;
      cur = next;
      next = temp;
      next.clear();
    }
    
  }
  
  private void fill(int x, int y, ArrayList<int[]> next, char[][] board, int rows, int columns) {
    // TODO Auto-generated method stub
    if (x < 0 || x >= rows || y < 0 || y >= columns || board[x][y] != 'O')
      return;
    
    int[] pos = {x,y};
    next.add(pos);
    board[x][y] = 'Y';
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SurroundedRegions so = new SurroundedRegions();
    char[][] board = {{'O'}};
    so.solve(board);
  }

}
