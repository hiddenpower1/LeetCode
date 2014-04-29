import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSumII {
  
  public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> sol = new ArrayList<Integer>();
    if(num.length == 0)
      return null;
    
    Arrays.sort(num);
    
    find(num,target,0,result,sol);
    return result;
  }
  
  private void find(int[] num, int remain, int pos, ArrayList<ArrayList<Integer>> result,
      ArrayList<Integer> sol) {
    // TODO Auto-generated method stub
    ArrayList<Integer> temp = new ArrayList<Integer>(sol);
    
    if(remain == 0){
      result.add(temp);
      return;
    }
    
    if(pos == num.length){
      return;
    }
    
    //find duplicates of current pos
    int i = 1;
    while(pos+i<num.length && num[pos+i]==num[pos]){
      i++;
    }
    
    //do not include current pos
    find(num,remain,pos+i,result,temp);
    
    //include current pos as many time as possible
    int j = 1;
    while(j*num[pos]<=remain && j<=i){
      temp.add(num[pos]);
      find(num,remain - j*num[pos],pos+i,result,temp);
      j++;
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
