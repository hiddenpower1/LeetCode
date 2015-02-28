import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSumII {
  
  public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> set = new ArrayList<Integer>();
    Arrays.sort(candidates);
    generate(candidates,result,set,0,target);
    return result;
}

private void generate(int[] nums,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> set, int start,int target){
    if(target == 0){
        result.add(new ArrayList<Integer>(set));
        return;
    }
    
    for(int i = start;i<nums.length;i++){
        if(nums[i]<=target){
          if (i == start || nums[i] != nums[i-1]){
            set.add(nums[i]);
            generate(nums,result,set,i+1,target-nums[i]);
            set.remove(set.size()-1);
          }
        }else
           break;
    }
}

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] cand = {2,5,2,1,2};
    CombinationSumII so = new CombinationSumII();
    so.combinationSum2(cand, 5);
    System.out.print(1);
  }

}
