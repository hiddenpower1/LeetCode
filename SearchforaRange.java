
public class SearchforaRange {
  public int[] searchRange(int[] A, int target) {
    
    int[] result = {-1,-1};
    if(A == null || A.length == 0)
      return result;
    
    int left = 0;
    int right = A.length-1;
    while(left<=right){
      int mid = (left+right)/2;
      // we find a range at least
      if(target == A[mid]){
        result[0] = findstart(left,mid,A,target);
        result[1] = findend(mid,right,A,target);
        return result;
      }
      
      if(target<A[mid]){
        right = mid -1;
      }else{
        left = mid + 1;
      }
    }
    
    return result;
    
    
  }
  private int findstart(int left, int mid, int[] A, int target) {
    // TODO Auto-generated method stub
    int start = mid;
    while(left<mid){
      int center = (left+mid)/2;
      
      if (target == A[center]){
        start = center;
        mid = center-1;
      }else{
        left = center + 1;
      }
    }
    return start;
  }
  
  private int findend(int mid, int right, int[] A, int target) {
    // TODO Auto-generated method stub
    int end = mid;
    while(mid<right){
      int center = (right+mid)/2;
      
      if (target == A[center]){
        end = center;
        mid = center + 1;
      }else{
        right = center - 1;
      }
    }
    return end;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
