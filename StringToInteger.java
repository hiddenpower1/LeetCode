
public class StringToInteger {

  public int atoi(String s){
    s = s.trim();
    
    int result = 0;
    boolean pos = true;
    
    
    
    for(int i = 0;i<s.length();i++){
      if(Character.isDigit(s.charAt(i))){
        //need cast the int to long, otherwise it will overflow before assign to exceed
        long exceed = (long)result*10+Character.digit(s.charAt(i), 10);
        if(exceed > Integer.MAX_VALUE || -exceed<Integer.MIN_VALUE){
          return pos == true ? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }else{
          result = result*10+Character.digit(s.charAt(i), 10);
        }

      }else{
        //check if the first character is plus or minus sign
        if (i==0 && (s.charAt(0) == '+' || s.charAt(0) == '-')){
          pos = (s.charAt(0) == '+' ? true:false);
        }else{
          
          return pos == true ? result:-result;
        }
      }
      
      
    }
    
    
    return pos == true ? result:-result;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    StringToInteger so = new StringToInteger();
    
//    long test = 214748364L*10+8;
//    System.out.print(test);
    
    System.out.print(so.atoi("-2147483648"));
  }

}
