
public class SortColors {
  public void sortColors(int[] A) {
    int size = A.length;
    if(size<2){
      return;
    }
    
    int red = 0;
    int blue = size-1;
    int cur = 0;
    while(cur<=blue){
      //if red, switch to front of the array
      if(A[cur] == 0){
        int temp = A[red];
        A[red] = A[cur];
        A[cur] = temp;
        red++;
        if(cur<red)
          cur++;
      }else{
        //if blue switch to end of the array
        if(A[cur] == 2){
          int temp = A[blue];
          A[blue] = A[cur];
          A[cur] = temp;
          blue--;
        }else{
          //if white, stay as is.
          cur++;
        }
      }
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
