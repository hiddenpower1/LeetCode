import java.util.ArrayList;
import java.util.HashMap;

public class SubstringwithConcatenationofAllWords {
  public ArrayList<Integer> findSubString(String S,String[] L){
    ArrayList<Integer> result = new ArrayList<Integer> ();
    if(S == null || L == null)
      return null;
    
    if(L.length == 0)
      return result;
    
    int length = S.length();
    int wordL = L[0].length();
    int subL = wordL*L.length;
    if (length < subL)
      return result;
    
    //Save all string in L to a hashmap, is key already exist, add 1
    HashMap <String,Integer> hm = new HashMap <String,Integer>();
    for( int i = 0;i<L.length;i++){
      if(hm.containsKey(L[i]))
        hm.put(L[i], hm.get(L[i])+1);
      else
        hm.put(L[i], 1);
    }
    
    for( int i = 0;i < length - subL + 1;i++){
      //HashMap <String,Boolean> hm1 = new HashMap<String, Boolean>(hm);
      if(isSubString(S.substring(i, i+subL),new HashMap<String, Integer>(hm),wordL))
        result.add(i);
    }
    
    return result;
  }

  private boolean isSubString(String substring, HashMap<String, Integer> hm, int wordL) {
    // TODO Auto-generated method stub
    int i = 0;
    while(!hm.isEmpty()){
      String key = substring.substring(i*wordL, (i+1)*wordL);
      if(hm.containsKey(key)){
        if(hm.get(key) == 1)
          hm.remove(key);
        else
          hm.put(key, hm.get(key)-1);
        i++;
      }
      else 
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
