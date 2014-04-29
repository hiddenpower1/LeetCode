
public class SearchinRotatedSortedArray {
  public int search(int[] A, int target) {

    if (A == null || A.length == 0)
      return -1;
        
    int left = 0;
    int right = A.length-1;
    
    
    //binary search
    while(left<=right){
      int mid = (left+right)/2;
      
      if (A[mid] == target) {
        return mid;
      } 
      
      //from left to mid is an ascending order
      if(A[left]<=A[mid]){
        if(target >= A[left] && target < A[mid])
          right = mid-1;
        else
          left = mid+1;
      }else{
      //from mid to right is in ascending order
        if(target > A[mid] && target <= A[right])
          left = mid+1;
        else
          right = mid -1;
      }
    }
    
    return -1;
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
