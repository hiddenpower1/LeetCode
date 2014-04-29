
public class RemoveDuplicatesfromSortedArray {
  public int removeDuplicates(int[] A){
    int length = A.length;
    if (length < 2)
      return length;
    
    int len = 1;
    for(int i = 1;i<length;i++){
      if(A[i] != A[len-1]){
        A[len] = A[i];
        len++;
      }
    }
    
    return len;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
