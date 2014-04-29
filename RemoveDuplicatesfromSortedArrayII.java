
public class RemoveDuplicatesfromSortedArrayII {

  public int removeDup(int[] A){
    int length = A.length;
    if (length<3)
      return length;
    
    int len = 2;
    for(int i=2;i<length;i++){
      if(A[i]!=A[len-1] || (A[i] == A[len-1] && A[i] != A[len-2])){
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
