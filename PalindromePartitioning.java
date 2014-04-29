import java.util.ArrayList;


public class PalindromePartitioning {
  public ArrayList<ArrayList<String>> partition(String s) {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    if(s.length()==0)
      return result;
    
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
    
    ArrayList<String> partition = new ArrayList<String>();
    find(0,s.length(),s,partition,matrix,result);
    
    return result;
  }
  
  
  
  private void find(int start, int length, String s, ArrayList<String> partition, boolean[][] matrix,
      ArrayList<ArrayList<String>> result) {
    // TODO Auto-generated method stub
    ArrayList<String> temp = new ArrayList<String> (partition);
    if(start == length){
      result.add(temp);
      return;
    }
    
    for(int i = start;i<length;i++){
      if(matrix[start][i]){
        temp.add(s.substring(start,i+1));
        find(i+1,length,s,temp,matrix,result);
        temp.remove(temp.size()-1);
      }
    }
    
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
