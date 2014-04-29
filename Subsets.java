import java.util.ArrayList;
import java.util.Arrays;


public class Subsets {
  public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    int size = S.length;
    ArrayList<Integer> set = new ArrayList<Integer>();
    Arrays.sort(S);
    
    for(int i=0;i<=size;i++){
      generate(S,i,set,0,result);
    }
    
    return result;
  }
  private void generate(int[] s, int n, ArrayList<Integer> set, int start,
      ArrayList<ArrayList<Integer>> result) {
    // TODO Auto-generated method stub
    ArrayList<Integer> temp = new ArrayList<Integer>(set);

    if(set.size()==n){
      result.add(temp);
      return;
    }
    
    //for(int i = start;i<=s.length+1-n+set.size();i++){
    for(int i = start;i<s.length;i++){

      temp.add(s[i]);
      generate(s,n,temp,i+1,result);
      temp.remove(temp.size()-1);
    }
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
