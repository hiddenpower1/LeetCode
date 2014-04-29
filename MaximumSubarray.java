
public class MaximumSubarray {
  public int maxSubArray(int[] A) {
    
    //DP, the maxsubarray include certain pos is determined by the sum to it's left. 
    int length = A.length;
    
    if(length == 0)
      return Integer.MIN_VALUE;

    
    int[] maxLeft = new int[length];
    int[] maxRight = new int[length];
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for(int i=0;i<length;i++){
      sum = sum+A[i];
      if (max>sum)
        max = sum;
      if(sum<0)
        sum = 0;

    }
    

    
    return max;
    
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
