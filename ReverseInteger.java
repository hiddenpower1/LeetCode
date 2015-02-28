
public class ReverseInteger {
  public int reverseInteger(int x){
    int result = 0;
    int remain = x;
    while(remain!=0){
      
      //need cast the int to long, otherwise it will overflow before assign to exceed
//      long exceed = (long)result*10+remain%10;
//      if(exceed>Integer.MAX_VALUE || exceed<Integer.MIN_VALUE)
 //       return -1;
      if(x>0 && (Integer.MAX_VALUE-remain%10)/10 < result){
        return -1;
      }
      
      
      result = result*10+remain%10;
      remain = remain/10;
    }
    
    return result;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ReverseInteger ri = new ReverseInteger();
    System.out.print(ri.reverseInteger(-1234));

  }

}
