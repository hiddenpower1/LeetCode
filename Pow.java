
public class Pow {
  public double pow(double x, int n) {
    if(x==0){
      if(n==0)
        return 1;
      else
        return 0;
    }
    
    if(x==1 || n==0)
      return 1;

    int remain = 0;
    long absn = Math.abs((long)n);
    double result = x;
    int power = 1;
    while (absn/2>0){
      result = result*result;
      remain = (int) (remain+absn%2*power);
      power = power*2;
      absn = absn/2;
    }
    
    result = result*pow(x,remain);
    
    if(n>0)
      return result;
    else
      return 1/result;
    
  }
  
  
  public double pow2(double x, int n) {
    if(x==0){
      if(n==0)
        return 1;
      else
        return 0;
    }
    
    if(x==1 || n==0)
      return 1;
      
    if(n==1)
        return x;
    
    long absn = Math.abs((long) n);
    double result = powabs(x,absn);
    
    return n>0?result:1/result;
}

private double powabs(double x, long absn){
    if(absn == 1)
         return x;
    if(absn == 0)
        return 1;
    
    double a = powabs(x,absn/2);
    double b = powabs(x,absn%2);
    return a*a*b;
}
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Pow so = new Pow();
    
    System.out.println(so.pow2(3.3, 2));
  }

}
