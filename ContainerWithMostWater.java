
public class ContainerWithMostWater {
  
  public int mostWater(int[] height){
    int result = 0;
    int i = 0;
    int j = height.length-1;
    while (i<j){
      if(height[i]<=height[j]){
        result = result>=height[i]*(j-i)?result:height[i]*(j-i);
        i++;
      }else{
        result = result>=height[j]*(j-i)?result:height[j]*(j-i);
        j--;
      }
    }
    
    return result;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
