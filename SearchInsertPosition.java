
public class SearchInsertPosition {
  public int searchInsert(int[] A, int target) {

    if (A.length == 0)
      return 0;
    
    int left = 0;
    int right = A.length-1;
    int mid = 0;
    while(left<=right){
      mid = (left+right)/2;
      
      if(target == A[mid])
        return mid;
      
      if(target< A[mid]){
        right = mid - 1;
      }else{
        left = mid+1;
      }
      
    }
    
    if(target<A[mid])
      return mid;
    else
      return mid+1;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
