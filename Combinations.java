import java.util.ArrayList;

public class Combinations {
  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if(n<1||k<1)
      return result;
    
    ArrayList<Integer> combine = new ArrayList<Integer>();
    generate(result,combine,1,n,k);
    
    return result;
    
  }
  private void generate(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combine,int start,
      int n, int k) {
    // TODO Auto-generated method stub
    ArrayList<Integer> temp = new ArrayList<Integer>(combine);
    if (combine.size() == k){
      result.add(temp);
      return;
    }
       
    
    for(int i = start;i<=n;i++){
      combine.add(i);
      generate(result,combine,i+1,n,k);
      combine.remove(combine.size()-1);
    }
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
