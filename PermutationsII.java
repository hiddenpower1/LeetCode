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
    
    //-------
    
    public ArrayList<ArrayList<Integer>> permuteUnique2(int[] num) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      if(num.length == 0)
          return result;
      ArrayList<Integer> set = new ArrayList<Integer>();
      Arrays.sort(num);
      generate2(num,result,set,0);
      return result;
  }
  
  public void generate2(int[] num,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> set,int start){
      if(start == num.length){
          result.add(new ArrayList<Integer>(set));
          return;
      }
      
      for(int i =start;i<num.length;i++){
          if(i==start || !find(num,start,i,num[i])){
              swap(num,start,i);
              set.add(num[start]);
              generate2(num,result,set,start+1);
              set.remove(set.size()-1);
              swap(num,start,i);
          }
      }
  }
  
  private void swap(int[] num,int a,int b){
      int temp = num[a];
      num[a] = num[b];
      num[b] = temp;
  }
  
  private boolean find(int[] num,int start,int end,int target){
    for(int i = start;i<end;i++){
        if(num[i] == target)
            return true;
    }
    return false;
}
  
    
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] test = {0,1,0,0,9};
    PermutationsII so = new PermutationsII();
    so.permuteUnique2(test);
  }

}
