
public class ValidNumber {
  public boolean isNumber(String s) {
    s = s.trim();
    int length = s.length();
    
    if(length == 0)
      return false;
    
    boolean hasDigits = false;
    boolean hasE = false;
    boolean hasDot = false;
    
    int i = 0;
    //processing leading '+' or '-'
    if(s.charAt(i) == '+' || s.charAt(i) == '-')
      i++;
    
    for(;i<length;i++){
      //not digit
      if(!Character.isDigit(s.charAt(i))){
        //if the current character is 'e', it must already have digit, and can not have 'e', can't be the last character of the string
        //the next character must be digit or '+' or '-'
        if(s.charAt(i) == 'e' ){
          if(hasDigits && !hasE && i<length-1 && (s.charAt(i+1) == '+' || s.charAt(i+1) == '-' || Character.isDigit(s.charAt(i+1)))){
            hasE = true;
            //if the character after e is '+' or '-'
            if(s.charAt(i+1) == '+' || s.charAt(i+1) == '-'){
              if(i+1<length-1)
                i++;
              else
                return false;
            }
            continue;
          }else
            return false;
        }
        
     // if the current character is '.', it can't have '.' already. can't have 'e' already.
        if (s.charAt(i) == '.'){
          if(hasDigits && !hasDot && !hasE){
            hasDot = true;
            continue;
          }else
            return false;
        }
        
        return false;
      }else{
        //is digits
        hasDigits = true;
        
      }
    }
    
    return hasDigits;
    
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
