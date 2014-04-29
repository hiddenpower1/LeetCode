
public class SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    
    if (n==0)
      return null;
    
    int[][] matrix = new int[n][n];
    int layer = 0;
    int count = 1;
    while(layer<n-1-layer){
      for(int i=layer;i<n-1-layer;i++){
        matrix[layer][i] = count;
        count++;
      }
      
      for(int i=layer;i<n-1-layer;i++){
        matrix[i][n-1-layer] = count;
        count++;
      }
      
      for(int i=n-1-layer;i>layer;i--){
        matrix[n-1-layer][i] = count;
        count++;
      }
      
      for(int i=n-1-layer;i>layer;i--){
        matrix[i][layer] = count;
        count++;
      }
      
      layer++;
    }
    
    if(n%2 == 1){
      matrix[layer][layer] = count;
    }
    
    return matrix;
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
