import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class GenerateParentheses {
  public ArrayList<String> generateParentheses(int n){
    ArrayList<String> result = new ArrayList<String> ();
    
    String seq = "";
    
    if (n==0)
      return result;
    
    generate(0,0,n,result,seq);
    return result;
  }

  private void generate(int left, int right, int n, ArrayList<String> result, String seq) {
    // TODO Auto-generated method stub
    if (right == n && left == n){
      result.add(seq);
      return;
    }
    
    
    if(left<n){
      generate(left+1,right,n,result,seq+"(");
    }
    
    if (right<left && right < n){
      generate(left,right+1,n,result,seq+")");
    }

    
  }
  
  
  public ArrayList<String> generateParentheses_hashset(int n){
    ArrayList<String> result = new ArrayList<String> ();
    
    
    if (n==0)
      return result;
    
    
    HashSet<String> hs = new HashSet<String>();

    hs = generate(n);
    
    Iterator<String> it = hs.iterator();
    while(it.hasNext()){
      result.add(it.next());
    }
    
    return result;
  }

  private HashSet<String> generate(int n) {
    // TODO Auto-generated method stub
    HashSet<String> work = new HashSet<String>();
    HashSet<String> result = new HashSet<String>();

    if ( n ==1) {
      result.add("()");
      return result;
    }
    
    work = generate(n-1);
    Iterator<String> it = work.iterator();
    while(it.hasNext()){
      String s= it.next();
      result.add("()"+s);
      for(int i=0;i<s.length();i++){
          result.add(s.substring(0,i+1)+"()"+s.substring(i+1,s.length()));
      }
    }
    
    return result;
    
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
