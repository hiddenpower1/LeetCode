import java.util.ArrayList;


public class NQueen {
  public ArrayList<String[]> solveNQueens(int n) {
    ArrayList<String[]> result = new ArrayList<String[]>();
    int[] sol = new int[n];
    placeQueen(n,sol,0,result);
    return result;
  }
  
  private void placeQueen(int n, int[] sol, int row, ArrayList<String[]> result) {
    // TODO Auto-generated method stub
    if(row == n){
      result.add(tranform(sol));
      return;
    }
    
    for(int i = 0;i<n;i++){
      if(canPlace(row,i,sol)){
        sol[row] = i;
        placeQueen(n,sol,row+1,result);
      }
    }
    
    
  }
  
  private boolean canPlace(int row, int col, int[] sol) {
    // TODO Auto-generated method stub
    for(int i = 0;i<row;i++){
      //check col
      if(sol[i] == col)
        return false;
      //check diagonal
      if(row-i == Math.abs(sol[i] - col))
        return false;
    }
    
    return true;
  }

  private String[] tranform(int[] sol) {
    // TODO Auto-generated method stub
    int n = sol.length;
    String[] board = new String[n];
    for(int i =0;i<n;i++){
      StringBuffer sb = new StringBuffer();
      for(int j = 0;j<n;j++){
        if(j==sol[i])
          sb.append('Q');
        else
          sb.append('.');
      }
      board[i] = new String(sb);
    }
    return board;
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
