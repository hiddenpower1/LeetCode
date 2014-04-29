
import java.util.*;

public class TwoSum {
  
  public int[] twoSum (int[] numbers, int target){
    
    int[] result = new int[2];
    HashMap <Integer,Boolean> hm = new HashMap<Integer,Boolean> ();
    
    for (int i = 0;i<numbers.length;i++){
      if (!hm.containsKey(numbers[i])){
        hm.put(target-numbers[i], true);
      }else{
        for(int j = 0;j<i;j++){
          if(numbers[i]+numbers[j] == target){
            result[0] = j+1;
            result[1] = i+1;
            return result;
          }
            
        }
      }
    }
    
    return result;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
