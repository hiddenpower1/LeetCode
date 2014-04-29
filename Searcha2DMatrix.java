public class Searcha2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    //binary search
    int row = matrix.length;
    if (row == 0)
      return false;
    int col = matrix[0].length;
    if (col == 0)
      return false;
    
    int start = 0;
    int end = row-1;
    
    while(start<=end){
      int mid = (start+end)/2;
      if(matrix[mid][0] == target)
        return true;
      
      if(matrix[mid][0]>target){
        end = mid-1;
      }else{
        start = mid+1;
      }
    }
    
    //if target is smaller than matrix[0][0], it will be false
    if(end<0)
      return false;
    else{
      //otherwise, it will be found on the row = end
      int currentRow = end;
      start = 0;
      end = col-1;
      
      while(start<=end){
        int mid = (start+end)/2;
        if(matrix[currentRow][mid] == target)
          return true;
        
        if(matrix[currentRow][mid]>target){
          end = mid-1;
        }else{
          start = mid+1;
        }
      }
      return false;
    }
    
    
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
