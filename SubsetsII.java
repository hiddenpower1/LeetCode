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
  
  
  public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(num);
    for(int i = 0;i<=num.length;i++){
        ArrayList<Integer> set = new ArrayList<Integer>();
        generate2 (num,result,set,0,i);
    }
    return result;
}

private void generate2(int[] num,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> set, int start ,int size){
    if(set.size() == size){
        result.add(new ArrayList<Integer>(set));
        return;
    }
    
    for(int i = start;i<num.length;i++){
        if(i == start || num[i]!= num[i-1]){
            set.add(num[i]);
            generate2(num,result,set,start+1,size);
            set.remove(set.size()-1);
        }
    }
}

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] a = {1,2,3,4,5,6,7,8,10,0};
    SubsetsII so = new SubsetsII();
    so.subsetsWithDup2(a);
  }

}
