import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Anagrams {
  public ArrayList<String> anagrams(String[] strs) {
    ArrayList<String> result = new ArrayList<String>();
    
    if(strs.length<2)
      return result;
    
    boolean[] used = new boolean[strs.length];
    for(int i =0 ;i < strs.length-1; i++){
      if(!used[i]){
        for(int j = i+1;j<strs.length;j++){
          if(!used[j] && strs[i].length() == strs[j].length()){
            if(isAnagrams(strs[i],strs[j])){

                if(!used[i]){
                  used[i] = true;
                  result.add(strs[i]);
                }
                used[j] = true;
                result.add(strs[j]);

            }
          }
          
        }
      }
    }
    
    return result;
    
  }
  
  private boolean isAnagrams(String s1, String s2) {
    // TODO Auto-generated method stub
    char[] ss1 = s1.toCharArray();
    
    char[] ss2 = s2.toCharArray();
    
    Arrays.sort(ss1);
    Arrays.sort(ss2);
    return ss1.equals(ss2);

  }
  
  
  public ArrayList<String> anagrams_hashmap(String[] strs) {
    ArrayList<String> result = new ArrayList<String>();
    
    if(strs.length<2)
      return result;
    
    HashMap<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();
    for(int i =0 ;i<strs.length;i++){
      //sort the string
      char[] temp = strs[i].toCharArray();
      Arrays.sort(temp);
      String s = new String(temp);
      //String s = temp.toString();
      
      //put the string to the hm of under the key of it's sorted string
      if(!hm.containsKey(s)){
        ArrayList<String> al = new ArrayList<String>();
        al.add(strs[i]);
        hm.put(s, al );
      }else{
        hm.get(s).add(strs[i]);
      }     
    }
    
    Iterator<ArrayList<String>> it = hm.values().iterator();
    while(it.hasNext()){
      ArrayList<String> al = it.next();
      if(al.size()>=2){
        result.addAll(al);
      }
    }
    
    return result;
    
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String[] strs = {"",""};
    Anagrams so = new Anagrams();
    System.out.print(so.anagrams_hashmap(strs));
  }

}
