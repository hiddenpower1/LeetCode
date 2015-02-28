
public class DivideTwoIntegers {
  public int divide(int dividend, int divisor) {
    
    if (dividend == 0 || divisor == 0)
      return divisor == 0? null:0;
    
    boolean isNeg = false;
    
    if ((dividend < 0 && divisor >0) || (dividend >0 && divisor < 0))
      isNeg = true;
    
    long dd = Math.abs((long)dividend);
    long ds = Math.abs((long)divisor);
    
    long result = 0;
    long c = 1;
    while (dd>=ds){
      //<<1 is equal to multiply 2
      ds = ds<<1;
      c= c<<1;
    }
    
    while(dd>=Math.abs((long)divisor)){
      if(dd>=ds){
        dd = dd-ds;
        result = result+c;
      }
      ds = ds>>1;
      c = c>>1;
    }


    if (result>Integer.MAX_VALUE && !isNeg)
      return Integer.MAX_VALUE;
  
    return isNeg?-(int)result:(int)result;
    
  }
  
  
  public int divide2(int dividend, int divisor) {
    
    boolean isNeg = false;

    if ((dividend < 0 && divisor >0) || (dividend >0 && divisor < 0))
    isNeg = true;
    int result = 0;
    long remain = Math.abs((long)dividend);
    long ds = Math.abs((long)divisor);
    
    long i = 1;
    while(ds<=(remain>>1)){
            ds = ds<<1;
            i = i<<1;
    } 
    while(remain>=Math.abs((long)divisor)){
        if(remain>=ds){
            result = result + (int)i;
            remain = remain - ds;
        }
        i = i>>1;
        ds = ds>>1;
    }
    
    return isNeg?-result:result;
}
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    DivideTwoIntegers so = new DivideTwoIntegers();
    System.out.print(so.divide(Integer.MIN_VALUE, 1));
  }

}
