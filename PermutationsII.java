import java.util.ArrayList;
import java.util.Arrays;


public class PermutationsII {
  public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    if(num.length == 0)
      return result;
    
    Arrays.sort(num);
    ArrayList<Integer> permute = new ArrayList<Integer>();
    ArrayList<Integer> used = new ArrayList<Integer>();
    
    generate(num,0,permute,used,result);
    
    return result;
    
  }
  private void generate(int[] num, int pos, ArrayList<Integer> permute, ArrayList<Integer> used,
      ArrayList<ArrayList<Integer>> result) {
    // TODO Auto-generated method stub
    ArrayList<Integer> temp = new ArrayList<Integer>(permute);
    if (pos == num.length){
      result.add(temp);
      return;
    }
    
    ArrayList<Integer> values = new ArrayList<Integer>();
    for(int i = 0;i<num.length;i++){
      if(!used.contains(i) && !values.contains(num[i])){
        temp.add(num[i]);
        used.add(i);
        values.add(num[i]);
        generate(num,pos+1,temp,used,result);
        used.remove(used.size()-1);
        temp.remove(temp.size()-1);
      }
    }
    
  }
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
