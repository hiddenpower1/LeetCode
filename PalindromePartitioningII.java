
public class PalindromePartitioningII {
  public int minCut(String s) {
    if(s.length()==0)
      return 0;
    
    //find all possible palindrome Partitions in the string
    boolean[][] matrix = new boolean[s.length()][s.length()];
    for(int i=0;i<s.length();i++){
      matrix[i][i]=true;
    }
    
    for(int j = 1;j<s.length();j++){
      for(int i=0;i<j;i++){
        if(s.charAt(i) == s.charAt(j)){
          if(i+1<=j-1)
            matrix[i][j] = matrix[i+1][j-1];
          else
            matrix[i][j] = true;
        }
      }
    }
    
    //Define min[i] = the minimum cut from 0 to i in the string.
    int[] min = new int[s.length()];
    min[0] = 0;
    
    for(int i =0;i<s.length();i++){
      //partition from 0 to i is palindrom
      int temp = s.length();
      if(matrix[0][i] == true)
        min[i] = 0;
      else{
        for(int j=1;j<=i;j++){
          //from j to i is palidrom, possible min cut is min[j-1]+1
          if(matrix[j][i] == true && temp > min[j-1]+1){
            temp = min[j-1]+1;
          }
        }
        
        min[i] = temp;
      }
      
    }
    
    return min[s.length()-1];
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
