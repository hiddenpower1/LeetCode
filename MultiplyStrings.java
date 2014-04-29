
public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    if(num1 == null || num2 == null )
      return null;
        
    if (num1.equals("0") || num2.equals("0"))
      return "0";
    
    String result = "";
    
    //for each digits in num2 multiply each digits in num1. each digits count with all digits in num1, save the temp.  then add up all such temp.
    for(int i= num2.length()-1;i>=0;i--){
      
      if(num2.charAt(i) == '0')
        continue;
      
      String temp = "";
      int carry = 0;
      for(int j = num1.length()-1;j>=0;j--){
        int digit = Character.digit(num2.charAt(i), 10)*Character.digit(num1.charAt(j), 10)+carry;
        carry = digit/10;
        temp = (char)('0'+ digit%10) + temp;
      }
      
      if (carry != 0)
        temp = (char)('0'+carry) +  temp;
      
      //add 0 at the end, to match up.
      int count = num2.length()-1-i;
      while(count>0){
        temp = temp+'0';
        count--;
      }
      
      //add the current temp to result
      result = add(temp,result);
      
    }
    
    return result;
    
  }
  private String add(String s1, String s2) {
    // TODO Auto-generated method stub
      int i = s1.length()-1;
      int j = s2.length()-1;
      int carry = 0;
      String result = "";
      while(i>=0 && j>=0){
        int digit = Character.digit(s1.charAt(i), 10)+ Character.digit(s2.charAt(j), 10)+carry;
        carry = digit/10;
        result = (char)('0'+digit%10) + result;
        i--;
        j--;
      }
      
      while (i>=0){
        int digit = Character.digit(s1.charAt(i), 10) + carry;
        carry = digit/10;
        result = (char)('0'+digit%10) + result;
        i--;
      }
      
      while (j>=0){
        int digit = Character.digit(s2.charAt(j), 10) + carry;
        carry = digit/10;
        result = (char)('0'+digit%10) + result;
        j--;

    }
      
      if (carry != 0)
        result = (char)('0'+carry) +  result;
      
      return result;

  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s1 = "498828660196";
    String s2 = "840477629533";
    MultiplyStrings so = new MultiplyStrings();
    System.out.println(so.multiply(s1, s2));
  }

}
