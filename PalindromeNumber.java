
public class PalindromeNumber {
  public boolean isPalidromeNumber(int x){
    
    if(x<0)
      return false;
    
//    if(x == 0)
//      return true;
    
    int div = 1;
    while (x/div > 10){
      div = div * 10;
  }
    
    while(x>=10 && x/div == x%10){
      x = (x%div)/10;
      div=div/100;
    }
    
    return x>=10?false:true;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    PalindromeNumber so = new PalindromeNumber();
    so.isPalidromeNumber(1874994781);
  }

}
