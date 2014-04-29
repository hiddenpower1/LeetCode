import java.util.ArrayList;

public class SpiralMatrix {
  public ArrayList<Integer> spiralOrder(int[][] matrix) {
    
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    if(matrix.length==0)
      return result;
    
    int m = matrix.length;
    int n = matrix[0].length;
    
    int row = 0;
    int col = 0;
    
    //while have both row and column left, get the outside
    while(row<m-1-row && col<n-1-col){
      for(int i=col;i<n-1-col;i++){
        result.add(matrix[row][i]);
      }
      
      for (int j = row;j<m-1-row;j++){
        result.add(matrix[j][n-1-col]);
      }
      
      for(int i=n-1-col;i>col;i--){
        result.add(matrix[m-1-row][i]);
      }
      
      for (int j = m-1-row;j>row;j--){
        result.add(matrix[j][col]);
      }
      row++;
      col++;
    }
    
    //handle there are only one row or column left.
    if(row==m-1-row && col==n-1-col){
      result.add(matrix[row][col]);
    }else{
      if(row==m-1-row){
        for(int i=row;i<n-row;i++){
          result.add(matrix[row][i]);
        }

      }
      
      if(col==n-1-col){
        for(int i=col;i<m-col;i++){
          result.add(matrix[i][col]);
        }
      }
    }
    
    return result;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
