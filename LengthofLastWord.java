
public class LengthofLastWord {
  
  public int lengthOfLastWord(String s){
    
    if(s==null || s.length()==0)
      return 0;
    
    //find first character from string end that is not space set as word end.
    int end =s.length()-1;
    while(end>=0 && s.charAt(end) == ' '){
      end--;
    }
    
    //find first character from end that is space set as word start
    int start = end;
    while(start>=0 && s.charAt(start) != ' '){
      start--;
    }
    
    return end-start;
    
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
