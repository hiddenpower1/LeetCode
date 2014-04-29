import java.util.ArrayList;
import java.util.Collections;


public class Triangle {
  public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    ArrayList<Integer> pre = new ArrayList<Integer>();
    ArrayList<Integer> cur = new ArrayList<Integer>();
    if (triangle.size() == 0)
      return 0;
    

    pre = triangle.get(0);

    for(int i = 1;i<triangle.size();i++){
      cur = triangle.get(i);
      //first node
      cur.set(0, cur.get(0)+pre.get(0));
      
      //mid
      for(int j=1;j<cur.size()-1;j++){
        cur.set(j, Math.min(cur.get(j)+pre.get(j-1), cur.get(j)+pre.get(j)));
      }
      //last node
      cur.set(cur.size()-1, cur.get(cur.size()-1)+pre.get(pre.size()-1));
  
      ArrayList<Integer> temp = pre;
      pre = cur;
      cur = temp;
      cur.clear();
    }
    
    //sort pre and return the minimum 
    Collections.sort(pre);
    return pre.get(0);

  }
  
  public int minimumTotal_bottomUp(ArrayList<ArrayList<Integer>> triangle) {
    ArrayList<Integer> pre = new ArrayList<Integer>();
    ArrayList<Integer> cur = new ArrayList<Integer>();
    if (triangle.size() == 0)
      return 0;
    
    pre = triangle.get(triangle.size()-1);

    for(int i = triangle.size()-2;i>=0;i--){
      cur = triangle.get(i);

      for(int j=0;j<cur.size();j++){
        cur.set(j, Math.min(cur.get(j)+pre.get(j), cur.get(j)+pre.get(j+1)));
      }

      ArrayList<Integer> temp = pre;
      pre = cur;
      cur = temp;
      cur.clear();
    }
    
    //sort pre and return the minimum 
    Collections.sort(pre);
    return pre.get(0);
  }

    
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
