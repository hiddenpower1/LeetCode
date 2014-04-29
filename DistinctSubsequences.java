
public class DistinctSubsequences {
  public int numDistinct(String S, String T) {
    //dp
    if(T.length() == 0)
      return 1;
    
    //s is empty, and T at this point can not be empty, return 0.
    if(S.length()==0)
      return 0;
    
    //s and t both not empty
    int[][] num = new int[S.length()+1][T.length()+1];
    
    num[0][0] = 1;
    
    for(int i = 1;i<=S.length();i++){
      num[i][0] = 1;
    }
    
    for(int i=1;i<=T.length();i++){
      num[0][i] = 0;
    }
    
    for(int i = 1;i<=S.length();i++){
      for(int j = 1;j<=T.length();j++){
        if(j<=i){
          //if last character is the same
          if(S.charAt(i-1) == T.charAt(j-1))
            num[i][j] = num[i-1][j-1] + num[i-1][j]; 
          else
            //last character is not same.
            num[i][j] = num[i-1][j];
        }else{
          num[i][j] = 0;
        }
      }
    }
    
    return num[S.length()][T.length()];
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
