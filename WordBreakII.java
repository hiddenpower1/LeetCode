import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class WordBreakII {
  public ArrayList<String> wordBreak(String s, Set<String> dict) {
    ArrayList<String> result = new ArrayList<String>();
    if(s.length()==0 || dict.size()==0)
        return result;
    
    StringBuffer sb = new StringBuffer();
    //valid array, record if substring i..n can create a valid word break.
    boolean[] valid = new boolean[s.length()+1];
    //initial as all true. and set to false during the loop.
    for(int i=0;i<=s.length();i++)
      valid[i] = true;
        
    find(0,sb,s,dict,result, valid);
    
    return result;
    
}

private void find(int start, StringBuffer sb, String s, Set<String> dict, ArrayList<String> result,boolean[] valid) {
    // TODO Auto-generated method stub
    if(start==s.length()){
        //remove the last space and add to result
         result.add(new String(sb.substring(0, sb.length()-1)));
    }

    for(int i=start+1;i<=s.length();i++){
        if(dict.contains(s.substring(start,i))&&valid[i]){
          StringBuffer temp = new StringBuffer(sb);
          temp.append(s.substring(start,i) + " ");
          //record result's size before call the find
          int beforeChange = result.size();
          find(i,temp,s,dict,result,valid);
          //if result size is the same, which means no new result find for start at i.
          if(result.size() == beforeChange)
            valid[i] = false;
        }
    }
    
    
}





  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s = "catsanddog";
    Set<String> dict = new HashSet<String>();
    dict.add("cat");
    dict.add("cats");
    dict.add("and");
    dict.add("dog");
    dict.add("sand");
    
    WordBreakII so = new WordBreakII();
    so.wordBreak(s, dict);
  }

}
