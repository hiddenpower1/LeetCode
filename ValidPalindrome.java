public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    // empty or single character string is ture.
    if (s.length() < 2)
      return true;

    int start = 0;
    int end = s.length() - 1;
    while (start <= end) {
      while (start <=end && !Character.isLetterOrDigit(s.charAt(start))) {
        start++;
      }
      while (start<= end && !Character.isLetterOrDigit(s.charAt(end))) {
        end--;
      }
      
      if(start<= end ){
          if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
            start++;
            end--;
          } else{
            return false;
          }
        }
    }
    
    return true;

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
