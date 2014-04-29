
public class MinimumPathSum {
  public int minPathSum(int[][] grid) {
    
    //dynamic programming
    int m = grid.length;
    if(m==0)
      return 0;
    
    int n = grid[0].length;
    if(n==0)
      return 0;
    
    int[][] paths = new int[m][n];

    paths[0][0] = grid[0][0];
    //first column all have 1 unique path 
    for(int i=1;i<m;i++){
      paths[i][0] = paths[i-1][0] + grid[i][0];
    }
    
    //same apply to first row
    for(int j=1;j<n;j++){
      paths[0][j] = paths[0][j-1]+grid[0][j];
    }
    
    //min paths to [i,j] is determined by min path to [i-1,j] and [i,j-1]
    for(int i = 1;i<m;i++){
      for(int j=1;j<n;j++){
        paths[i][j] = Math.min(paths[i-1][j],paths[i][j-1])+grid[i][j];
      }
    }
    
    return paths[m-1][n-1];
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
