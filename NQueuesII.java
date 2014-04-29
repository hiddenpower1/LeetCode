public class NQueuesII {
  public int totalNQueens(int n) {
    int[] sol = new int[n]; //the i-th element is the column number of the queen in the i-th row
    int result = 0;

    result = placeQueen(n,sol,0,result);
    return result;
  }
  private int placeQueen(int n, int[] sol, int row, int result) {
    // TODO Auto-generated method stub
    if ( row == n){
      result++;
      return result;
    }
    
    for(int i =0;i<n;i++){
      if(canPlace(sol,row,i)){
        sol[row] = i;
        result = placeQueen(n,sol,row+1,result);
      }
    }
    
    return result;
    
  }
  
  private boolean canPlace(int[] sol, int row, int col) {
    // TODO Auto-generated method stub
    for(int i=0;i<row;i++){
      if(sol[i] == col)
        return false;
      if(row-i == Math.abs(sol[i] - col))
        return false;
    }
    return true;
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
