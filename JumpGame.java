
public class JumpGame {
  public boolean canJump(int[] A) {
    int length = A.length;
    
    if (length < 2)
      return length == 1;
    
    int last = length-1;
    while(last>0){
      int i = 0;
     for(;i<last;i++){
       if ((i+ A[i]) >=last){
         break;
       }
     }
     if(i == last)
       return false;
     else
       last = i;
    }
    
    return true;
    
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
