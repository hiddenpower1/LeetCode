
public class MinimumWindowSubstring {
  public String minWindow(String S, String T) {
    if(T.length() == 0 || S.length()<T.length())
      return "";
    
    int[] need = new int[256];
    int[] have = new int[256];
    
    for(int i=0;i<T.length();i++){
      need[(int)T.charAt(i)]++;
    }
    
    int cur = 0;
    int curStart =0;
    int match = 0;
    int max =Integer.MAX_VALUE;
    int start = 0;
    int end = 0;
    
    while(cur<S.length()){
      have[(int)S.charAt(cur)]++;
      //if the current char is an exist char in T, and we don't have enough this char for a match
      if(have[(int)S.charAt(cur)] <= need[(int)S.charAt(cur)]){
        match++;
        //remove characters from head, till no longer match.
        while(match==T.length()){
          //if the head character is the same count, means after remove head, it will no longer match.
          if(have[(int)S.charAt(curStart)] == need[(int)S.charAt(curStart)]){
            int len = cur-curStart+1;
            if(len<max){
              start = curStart;
              end = cur;
              max = len;
            }
            match--;
          }
          have[(int)S.charAt(curStart)]--;
          curStart++;
        }
      }
      cur++;
      
    }
    
    if (max < Integer.MAX_VALUE) {
      return S.substring(start, end + 1);
    } else
      return "";
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
