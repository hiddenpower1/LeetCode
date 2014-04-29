
public class CountandSay {
  public String countAndSay(int n) {
    if (n == 0)
      return null;
    
    String result = "1";
    
    for(int i = 1; i<n;i++){
      result = generate(result);
    }
    
    return result;

  }
  
  private String generate(String s) {
    // TODO Auto-generated method stub
    int length = s.length();
    String read = "";
    int count = 1;
    char cur = s.charAt(0);
    for(int i = 1;i<length;i++){
        if(cur == s.charAt(i)){
          count++;
        }else{
          read = read+Character.forDigit(count, 10)+cur;
          cur = s.charAt(i);
          count = 1;
        }
        
    }
    
    //final add.
    read = read+Character.forDigit(count, 10)+cur;

    return read;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
