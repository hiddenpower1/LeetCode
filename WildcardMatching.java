
public class WildcardMatching {
  public boolean isMatch(String s, String p) {
    if(s == null || p == null)
      return false;
    
    if(p.length()==0)
      return s.isEmpty();
    
    
    //p's current char is *
    if(p.charAt(0) == '*'){
      int pos = 0;
      while(pos<p.length() && p.charAt(pos) == '*'){
        pos++;
      }
      for(int i = 0;i<=s.length();i++){
        if(isMatch(s.substring(i),p.substring(pos)))
          return true;
      }
      return false;
    }
    
    //current char is not *
    if(s.length()>=1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' ))
      return isMatch(s.substring(1),p.substring(1));
    else
      return false;
    
  }
  
  public boolean isMatch_DP(String s, String p) {
    if(s == null || p == null)
      return false;
    
    if(p.length()==0)
      return s.isEmpty();
    
    //pointer of s
    int i =0;
    //pointer of p
    int j = 0;
    int star = -1;
    int ss = 0;
    while(i<s.length() ){
      if(j<p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') ){
        i++;
        j++;
        continue;
      }
      
      if(j<p.length() && p.charAt(j) == '*'){
        //record the position of *
        star = j;
        //record the position of matched character of s
        ss = i;
        j++;
        continue;
        
      }
      
      //there are star recorded
      if(star>=0){
        j=star+1;
        i= ss + 1;
        ss++;
        continue;
      }
      
      return false;
      
    }
    
    while(j<p.length() && p.charAt(j) == '*')
      j++;
    
    return j==p.length()&&i == s.length();
    }
  
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
