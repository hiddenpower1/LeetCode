
public class RemoveElement {

  public int removeElement(int[] A, int elem){
    int length = A.length;

    
    int head = 0;
    int tail = length;
    while(head<tail){
      if(A[head] != elem){
          head++;
      }else{
        A[head] = A[tail-1];
        tail--;
      }
    }
    
    return tail;
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    RemoveElement so = new RemoveElement();
    int[] A = {1};
    System.out.println(so.removeElement(A, 1));
  }

}
