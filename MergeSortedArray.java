
public class MergeSortedArray {
  public void merge(int A[], int m, int B[], int n) {

    //from A,B's end ,compare, larger one place at A's end
    while(m>=1 && n>=1){
      if(A[m-1]<=B[n-1]){
        A[m+n-1] = B[n-1];
        //length--;
        n--;
      }else{
        A[m+n-1] = A[m-1];
        //length--;
        m--;
      }
        
    }
    
    if (m<1){
      while(n>=1){
        A[n-1] = B[n-1];
        n--;
      }
    }else{
       //do nothing, since A already sorted.
    }
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
