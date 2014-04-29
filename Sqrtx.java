
public class Sqrtx {

  public int sqrt(int x) {
    
    //binary search.
    //cast x to long first, cause it may overflow.
    //long longx = (long)x;
    
    long start = 0;
    long end = x;

    while(start<end){
      long mid = (start+end)/2;
      if(mid*mid==x)
        return (int)mid;
      
      if(mid*mid<x){
        start = mid+1;
      }else{
        end = mid-1;
      }
    }
    
    if(start*start>x)
      return (int)start-1;
    else
      return (int)start;
    
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
