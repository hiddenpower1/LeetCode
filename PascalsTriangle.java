import java.util.ArrayList;

public class PascalsTriangle {
  public ArrayList<ArrayList<Integer>> generate(int numRows) {
    //dp
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (numRows < 1)
      return result;
    
    ArrayList<Integer> cur = new ArrayList<Integer>();
    ArrayList<Integer> next = new ArrayList<Integer>();
    cur.add(1);
    result.add(new ArrayList<Integer>(cur));

    for(int i = 2;i<=numRows;i++){
      next.add(1);
      for(int j=1;j<i-1;j++)
        next.add(cur.get(j-1)+cur.get(j));
      next.add(1);
      result.add(new ArrayList<Integer>(next));
      ArrayList<Integer> temp = cur;
      cur = next;
      next = temp;
      next.clear();
    }
    
    
    
    
    return result;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
