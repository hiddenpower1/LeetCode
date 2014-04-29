
public class DivideTwoIntegers {
  public int divide(int dividend, int divisor) {
    
    if (dividend == 0 || divisor == 0)
      return divisor == 0? null:0;
    
    boolean isNeg = false;
    
    if ((dividend < 0 && divisor >0) || (dividend >0 && divisor < 0))
      isNeg = true;
    
    long dd = Math.abs((long)dividend);
    long ds = Math.abs((long)divisor);
    
    int result = 0;
    long c = 1;
    while (dd>ds){
      //<<1 is equal to multiply 2
      ds = ds<<1;
      c= c<<1;
    }
    
    while(dd>=Math.abs((long)divisor)){
      if(dd>=ds){
        dd = dd-ds;
        result = result+(int)c;
      }
      ds = ds>>1;
      c = c>>1;
    }
    return isNeg?-result:result;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
