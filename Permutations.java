import java.util.ArrayList;


public class Permutations {
  public ArrayList<ArrayList<Integer>> permute(int[] num) {
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    if(num.length == 0)
      return result;
    
    ArrayList<Integer> permute = new ArrayList<Integer>();
    
    generate(num,0,permute,result);
    
    return result;
    
    
  }
  private void generate(int[] num, int pos, ArrayList<Integer> permute,
      ArrayList<ArrayList<Integer>> result) {
    // TODO Auto-generated method stub
    
    ArrayList<Integer> temp = new ArrayList<Integer>(permute);
    if(pos==num.length){
      result.add(temp);
      return;
    }
    
    for(int i = 0;i<num.length;i++){
      if(!temp.contains(num[i])){
        temp.add(num[i]);
        generate(num,pos+1,temp,result);
        //remove the last digits added
        temp.remove(temp.size()-1);
      }
    }
    
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
