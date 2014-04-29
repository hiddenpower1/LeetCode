
public class RegularExpressionMatching {
  
  public boolean isMatch(String s, String p) {

    if (p.length()==0)
      return s.isEmpty();
    
    //p's next character is not * then the first character of p must match first character of s 
    if(p.length()==1 || p.charAt(1) != '*'){
      if(s.length()>=1 && (s.charAt(0) == p.charAt(0) || p.charAt(0)=='.'))
        return isMatch(s.substring(1),p.substring(1));
      else
        return false;
    }
    
    //p's next character is *
    if(p.charAt(0) == '.'){ //first character of p is . , then match all possible substring of s.
      for(int i = 0;i<=s.length();i++){
        if(isMatch(s.substring(i),p.substring(2)))
          return true;
      }
    }else{ 
      //first character of p is not ., then do a brute force exhaustive matching of 0, 1, or more 
      //repeats of current character of p¡­ Until we could not match any more characters.
      int i =0;
      while(i<=s.length() && (i==0 || (s.charAt(i-1) == p.charAt(0)))){
        if(isMatch(s.substring(i),p.substring(2)))
          return true;
        i++;
      }
      
    }
    
    return false;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
