import java.util.ArrayList;


public class PascalsTriangleII {
  public ArrayList<Integer> getRow(int rowIndex) {
    ArrayList<Integer> cur = new ArrayList<Integer>();
    ArrayList<Integer> next = new ArrayList<Integer>();
    if (rowIndex < 0)
      return cur;
    

    cur.add(1);

    for(int i = 1;i<=rowIndex;i++){
      next.add(1);
      for(int j=1;j<i;j++)
        next.add(cur.get(j-1)+cur.get(j));
      next.add(1);
      ArrayList<Integer> temp = cur;
      cur = next;
      next = temp;
      next.clear();
    }
    
    
    
    
    return cur;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
