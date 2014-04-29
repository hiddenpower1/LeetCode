
public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    
    if(matrix.length==0 || matrix[0].length ==0)
      return;
    
    int row = matrix.length;
    int col = matrix[0].length;
    
    boolean firstRow = false;
    boolean firstCol = false;
    
    //check firstrow contain 0 or not
    for(int i = 0;i<col;i++){
      if(matrix[0][i] == 0){
        firstRow = true;
        break;
      }
    }
    
    //check firstcol contain 0 or not
    for(int i = 0;i<row;i++){
      if(matrix[i][0] == 0){
        firstCol = true;
        break;
      }
    }
    
    //check the matrix, if find 0, set the mapping position in firstrow and firstcol to 0
    for(int i =1;i<row;i++){
      for(int j=1;j<col;j++){
        if(matrix[i][j] == 0){
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    
    //for each 0 in the first row, set the entire column to 0
    for(int i=1;i< col;i++){
      if(matrix[0][i] == 0){
        for(int j = 1;j<row;j++){
          matrix[j][i] = 0;
        }
      }
    }
    
    //for each 0 in the first column, set the entire row to 0
    for(int i=1;i< row;i++){
      if(matrix[i][0] == 0){
        for(int j = 1;j<col;j++){
          matrix[i][j] = 0;
        }
      }
    }
    
    //set firstrow to 0 if true
    if(firstRow){
      for(int i = 0;i<col;i++){
        matrix[0][i] = 0;
      }
    }
    
    //set firstcol to 0 if true
    if(firstCol){
      for(int i = 0;i<row;i++){
        matrix[i][0] = 0;
      }
    }
    
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
