
public class UniquePathsII {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    
    int m = obstacleGrid.length;
    if(m==0)
      return 0;
    
    int n = obstacleGrid[0].length;
    if(n==0)
      return 0;
    
    int[][] paths = new int[m][n];
    
    //first column all have 1 unique path 
    for(int i=0;i<m;i++){
      if(obstacleGrid[i][0] != 1)
        paths[i][0] = 1;
      else
        break;
    }
    
    //same apply to first row
    for(int j=0;j<n;j++){
      if(obstacleGrid[0][j] != 1)
        paths[0][j] = 1;
      else
        break;
    }
    
    //unique paths to [i,j] is determined by unique path to [i-1,j] and [i,j-1]
    for(int i = 1;i<m;i++){
      for(int j=1;j<n;j++){
        if(obstacleGrid[i][j] != 1)
          paths[i][j] = paths[i-1][j] + paths[i][j-1];
        else
          paths[i][j] = 0;
      }
    }
    
    return paths[m-1][n-1];
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
