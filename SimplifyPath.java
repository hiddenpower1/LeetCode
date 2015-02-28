import java.util.Stack;

public class SimplifyPath {
  public String simplifyPath(String path) {
    if(path == null)
      return null;
    
    if(path.length() == 0)
      return path;
    
    Stack<String> st = new Stack<String>();
    String[] s = path.split("/");
    
    for(int i=0;i<s.length;i++ ){
      if(s[i].equals("") || s[i].equals(".")){
        continue;
      }else{
        if(s[i].equals("..")){
          if(!st.isEmpty())
            st.pop();
        }else{
          st.push(s[i]);
        }
      }
    }
    
    StringBuffer sb = new StringBuffer();
    if (st.isEmpty()){
      sb.append("/");
      return sb.toString();
    }else{
      for(int i =0;i<st.size();i++){
        sb = sb.append('/');
        sb = sb.append(st.get(i));
      }
      return sb.toString();
    }
    
    
  }
  
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SimplifyPath so = new SimplifyPath();
    System.out.print(so.simplifyPath("/."));
  }

}
