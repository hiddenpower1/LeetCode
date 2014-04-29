
public class LongestPalindromicSubstring {

  //DP tp slove the problem.
  public String longestPalidromicSubstring_dp(String s){
    
    int length = s.length();
    int head = 0;
    int maxlen = 0;
    boolean[][] table = new boolean[length][length];
    
    //base case, for each character is self is a palindromic substring of lenght 1;
    for(int i = 0;i<length;i++){
      table[i][i] = true;
      maxlen = 1;
    }
    
    //base case, if i = i+1, then it form a palindromic substring of length 2
    for (int i=0;i<length-1;i++){
      if(s.charAt(i) == s.charAt(i+1)){
        table[i][i+1] = true;
        maxlen=2;
        head = i;
      }
    }
    
    //dp to solve the problem, loop from len = 3 to len = length 
    for (int len = 3;len<=length;len++){
      for(int i=0;i<length-len+1;i++){
        int j = i+len-1;
        if(s.charAt(i) == s.charAt(j) && table[i+1][j-1] == true){
          table[i][j] = true;
          maxlen = len;
          head = i;
        }
      }
    }
      
    return s.substring(head, head+maxlen);
  }
  
  
  //a palindromic string expand from it's center, and for sting s with length n, there are 2n-1 possible centers.
  public String longestPalidromicSubstring_expandFromCenter(String s){
    
    int length = s.length();
    int maxlen = 0;
    
    //in case s has length of 1.
    String max = s.substring(0,1);
    
    for (int i=0;i< length-1;i++){
      
      String s1 = expandFromCenter(s,i,i);
      if (s1.length()>maxlen){
        maxlen = s1.length();
        max = s1;
      }
      
      String s2 = expandFromCenter(s,i,i+1);
      if (s2.length()>maxlen){
        maxlen = s2.length();
        max = s2;
      }
      
      
    }
    
    return max;    
    
  }
  
  private String expandFromCenter(String s, int i, int j) {
    // TODO Auto-generated method stub
    while(i>=0&&j<s.length() && s.charAt(i)==s.charAt(j)){

        i--;
        j++;

    }
    return s.substring(i+1,j);
      
    //return null;
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
