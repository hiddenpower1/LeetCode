import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum {
  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> sol = new ArrayList<Integer>();
    if(candidates.length == 0)
      return null;
    
    Arrays.sort(candidates);
    
    find(candidates,target,0,result,sol);
    return result;
  }
  
  private void find(int[] cand, int remain, int pos, ArrayList<ArrayList<Integer>> result,
      ArrayList<Integer> sol) {
    // TODO Auto-generated method stub
    
    //Maintain a local copy of the current solution. 
    ArrayList<Integer> temp = new ArrayList<Integer>(sol);

    if (remain == 0){
      result.add(temp);
      return;
    }
    
    if(pos==cand.length)
      return;
    
    //not add current pos
    find(cand,remain,pos+1,result,temp);
    
    
    //add as much current pos as possible
    int i =1;
    while(i*cand[pos]<=remain){
      temp.add(cand[pos]);
      find(cand,remain - i*cand[pos],pos+1,result,temp);
      i++;
    }

  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    int[] cand = {1,2};
    CombinationSum so = new CombinationSum();
    so.combinationSum(cand, 3);
    System.out.print(1);
  }

}
