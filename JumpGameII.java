
public class JumpGameII {
  public int jump(int[] A) {
    if(A.length == 0)
      return 0;
    
    int last = A.length-1;
    int count = 0;
    while(last>0){
      int i = 0;
      for(;i<last;i++){
        if(i+A[i]>=last){
          count++;
          break;
        }
      }
      if(i == last){
        return 0;
      }else{
        last = i;
      }
      
    }
    
    return count;
    
    
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
