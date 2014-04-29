import java.util.Arrays;

public class SingleNumber {
  public int singleNumber(int[] A) {
    Arrays.sort(A);
    int i = 0;
    while (i < A.length - 1) {
      if (A[i] == A[i + 1])
        i = i + 2;
      else
        return A[i];
    }

    return A[A.length - 1];
  }


  public int singleNumber_bit(int[] A) {

	    int i = 0;
	    int result = 0;
	    while (i < A.length) {
	    	result = result^A[i];
	    	i++;
	    }

	    return result;
	  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
