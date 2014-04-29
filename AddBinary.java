
public class AddBinary {
  public String addBinary(String a, String b) {
    
    if(a==null || a.length() == 0){
      return b;
    }
    
    if(b==null || b.length() == 0){
      return a;
    }
    
    int lenA = a.length();
    int lenB = b.length();
    //String result = "";
    StringBuilder result = new StringBuilder();
    int carry = 0;
    while(lenA>0 && lenB>0){
      int sum = Character.digit(a.charAt(lenA-1),10) + Character.digit(b.charAt(lenB-1),10)+carry;
      carry = sum/2;
      //result = Character.forDigit(sum%2, 10)+result;
      result.insert(0, sum%2);
      lenA--;
      lenB--;
    }
    
    while (lenA>0){
      int sum = Character.digit(a.charAt(lenA-1),10) + carry;
      carry = sum/2;
      //result = Character.forDigit(sum%2, 10)+result;
      result.insert(0, sum%2);
      lenA--;
    }
    
    while (lenB>0){
      int sum = Character.digit(b.charAt(lenB-1),10) + carry;
      carry = sum/2;
      //result = Character.forDigit(sum%2, 10)+result;
      result.insert(0, sum%2);
      lenB--;
    }
    
    if(carry!=0){
      result.insert(0, carry);
    }
    
    return result.toString();
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
