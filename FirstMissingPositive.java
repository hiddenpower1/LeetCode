
public class FirstMissingPositive {
  public int firstMissingPositive(int[] A) {
    
    for(int i=0;i<A.length;i++){
      while(A[i] <= A.length && A[i]>0 && A[A[i]-1] != A[i]){
        int temp = A[A[i]-1];
        A[A[i]-1] = A[i];
        A[i] = temp;
      }
    }
    
    for(int i=0;i<A.length;i++){
      if(A[i]-1 != i){
        return i+1;
      }
    }
    
    return A.length+1;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
