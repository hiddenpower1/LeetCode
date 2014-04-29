
public class TrappingRainWater {
  public int trap(int[] A) {
    int length = A.length;
    if(length<3){
      return 0;
    }
    
    //find the leftMax for each position.
    int[] leftMax = new int[length];
    leftMax[0] = 0;
    for (int i = 1;i<length;i++){
      leftMax[i] = Math.max(leftMax[i-1], A[i-1]); 
    }
    
    //find the rightMax for current position can calc the sum
    int sum = 0;
    int rightMax = 0;
    for (int j = length-2;j>=0;j--){
      rightMax = Math.max(rightMax, A[j+1]);
      if(A[j]<Math.min(leftMax[j], rightMax))
        sum = sum+Math.min(leftMax[j], rightMax)-A[j];
        
    }
    
    return sum;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
