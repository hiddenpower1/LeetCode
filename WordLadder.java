import java.util.ArrayList;
import java.util.HashSet;


public class WordLadder {
  public int ladderLength(String start, String end, HashSet<String> dict) {
    //BFS is better than dfs
    if (start.length() == 0 || end.length() == 0 || dict.size()==0)
      return 0;
    
    ArrayList<String> next = new ArrayList<String>();
    ArrayList<String> cur = new ArrayList<String>();
    
    cur.add(start);
    int length = 1;
    while(!cur.isEmpty()){
      for(int i=0;i<cur.size();i++){
        StringBuilder word = new StringBuilder(cur.get(i));
        for(int j=0;j<word.length();j++){
          for(char m='a';m<='z';m++){
            char temp = word.charAt(j);
            if(temp == m)
              continue;
            word.setCharAt(j, m);
            if(word.toString().equals(end))
              return length+1;
            
            if(dict.contains(word.toString())){
              next.add(word.toString());
              dict.remove(word.toString());
            }
            
            //change word back;
            word.setCharAt(j, temp);
          }
        }
      }
      
      ArrayList<String> temp = cur;
      cur = next;
      next = temp;
      next.clear();
      length++;
    }
    
    return 0;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
