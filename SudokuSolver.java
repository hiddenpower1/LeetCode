
public class SudokuSolver {
  public void solveSudoku(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0)
      return;
    
    solved(board);
    
  }
  
  //recursive
  public boolean solved(char[][] board) {

    for(int i = 0;i<board.length;i++){
      for(int j = 0;j<board[0].length;j++){
        if(board[i][j] == '.'){
          for(char num = '1';num<='9';num++){
            if(isValid(i,j,num,board)){
              board[i][j] = num;
              if(solved(board))
                return true;
              else
                board[i][j] = '.';            
              }
          }
          return false;
        }
      }
    }
    
    return true;
  }

  private boolean isValid(int i, int j, char num, char[][] board) {
    // TODO Auto-generated method stub
    
    //check row and col
    for(int k = 0;k<9;k++){
      if(board[i][k] == num || board[k][j] == num)
        return false;
    }
      
      int x = i/3;
      int y = j/3;
      
      for(int row = x*3;row<x*3+3;row++){
        for(int col = y*3;col<y*3+3;col++){
          if(board[x][y] == num )
            return false;
      }
    }
    
    
    return true;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String[] str = { "53..7....", "6..195...", ".98....6.", "8...6...3",
            "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79" };
    
    String[] str1= {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
        board[i] = str1[i].toCharArray();
    }

    SudokuSolver so = new SudokuSolver();
    so.solveSudoku(board);
      for (int i = 0; i < 9; i++) {
        for(int j = 0;j<9;j++){
        System.out.print(board[i][j]);
        }
        System.out.print("\n");
      }
    

}

}
