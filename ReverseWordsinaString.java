
public class ReverseWordsinaString {
  public String reverseWords(String s) {
    if(s==null || s.length()==0)
      return s;
    
    String[] words = s.split(" ");
    StringBuffer result = new StringBuffer();
    
    for(int i=words.length-1;i>=0;i--){
      if(words[i].length()!=0){
        
        result.append(words[i]);
        result.append(" ");
      }
    }
    
    //remove the last space
    
    
    return result.toString().trim();
  }
 
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
