import java.util.ArrayList;
import java.util.Arrays;


public class SubsetsII {
  public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    int size = num.length;
    ArrayList<Integer> set = new ArrayList<Integer>();
    Arrays.sort(num);
    
    for(int i=0;i<=size;i++){
      generate(num,i,set,0,result);
    }
    
    return result;
  }
  
  private void generate(int[] num, int n, ArrayList<Integer> set, int start,
      ArrayList<ArrayList<Integer>> result) {
    // TODO Auto-generated method stub
    ArrayList<Integer> temp = new ArrayList<Integer>(set);

    if(set.size()==n){
      result.add(temp);
      return;
    }
    
    ArrayList<Integer> used = new ArrayList<Integer>();
    for(int i = start;i<num.length;i++){
      if(!used.contains(num[i])){
        temp.add(num[i]);
        generate(num,n,temp,i+1,result);
        temp.remove(temp.size()-1);
      }
      used.add(num[i]);
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
