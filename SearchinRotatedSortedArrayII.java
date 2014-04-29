
public class SearchinRotatedSortedArrayII {
  public boolean search(int[] A, int target) {
    
    if(A.length==0){
      return false;
    }
    
    int start =0;
    int end = A.length-1;
    
    while(start<=end){
      int mid = (start+end)/2;
      
      if(A[mid] == target)
        return true;
      
      //
      if(A[start]<=A[mid]){
        //from start to mid is sorted
        if(A[start]<A[mid]){
          if(target<A[mid] && target >= A[start]){
            end = mid-1;
          }else{
            start = mid+1;
          }
        }else{
          //can't determain if sorted, then we move to next one, then determin.
          start++;
        }
      }else{
        //from mid to end must be sorted.
          if(target>A[mid] && target <= A[end]){
            start = mid+1;
          }else{
            end = mid-1;
          }

      }
    }
    
    return false;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
