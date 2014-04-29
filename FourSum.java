import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FourSum {
  public ArrayList<ArrayList<Integer>> foursum(int[] num, int target) {

    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(num);

    for (int i = 0; i < num.length - 3; i++) {
      if (i == 0 || num[i] != num[i - 1]) {
        for (int j = i + 1; j < num.length - 2; j++) {
          if (j == i + 1 || num[j] != num[j - 1]) {
            int head = j + 1;
            int tail = num.length - 1;
            while (head < tail) {
              int temp = num[i] + num[j] + num[head] + num[tail];
              if (temp == target) {
                ArrayList<Integer> worker = new ArrayList<Integer>();
                worker.add(num[i]);
                worker.add(num[j]);
                worker.add(num[head]);
                worker.add(num[tail]);
                result.add(worker);
                head++;
                tail--;

                while (head < tail && num[head] == num[head - 1])
                  head++;
                while (head < tail && num[tail] == num[tail + 1])
                  tail--;
              } else {
                if (temp < target) {
                  head++;
                } else {
                  tail--;
                }
              }
            }
          }
        }
      }
    }


    return result;
  }


  public ArrayList<ArrayList<Integer>> foursum_hashMap(int[] num, int target) {

    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(num);

    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();

    
    //save all possible sum of each given pair to Hashmap
    for (int i = 0; i < num.length - 1; i++) {
      //if (i == 0 || num[i] != num[i - 1]) {
        for (int j = i + 1; j < num.length; j++) {
          //if (j == i + 1 || num[j] != num[j - 1]) {
            int temp = num[i]+num[j];
            ArrayList<Integer> tempAL = new ArrayList<Integer>();
            if(hm.containsKey(temp)){
              tempAL = hm.get(temp);
            }
            tempAL.add(i);
            tempAL.add(j);
            hm.put(temp, tempAL);
            

      }
    }
    
    //apply twosum to the sums in the hashmap
    Iterator<Map.Entry<Integer,ArrayList<Integer>>> it = hm.entrySet().iterator();
    while (it.hasNext()) {
        
        Map.Entry<Integer,ArrayList<Integer>> pairs = (Map.Entry<Integer,ArrayList<Integer>>)it.next();
        int remain = target - pairs.getKey();
      if (hm.containsKey(remain)) {

        ArrayList<Integer> al1 = hm.get(pairs.getKey());
        ArrayList<Integer> al2 = hm.get(remain);

        int x = 0;
        while (x < al1.size()) {
          // since the array is sorted, so just need to check if tl.get(x) > j to make sure the
          // remain sum pair will not contain i,j.
          int i = al1.get(x);
          int j = al1.get(x + 1);
          int y = 0;
          while (y < al2.size()) {
            if (al2.get(y) != i && al2.get(y+1) != i && al2.get(y) != j && al2.get(y+1) != j) {
              ArrayList<Integer> tempAL = new ArrayList<Integer>();
              tempAL.add(num[i]);
              tempAL.add(num[j]);
              tempAL.add(num[al2.get(y)]);
              tempAL.add(num[al2.get(y + 1)]);
              
              //sort the array before add to avoid duplicates
              Collections.sort(tempAL);
              if(!result.contains(tempAL))
                result.add(tempAL);
              
              y = y + 2;

              // avoid duplicate, when num[tl.get(x)] == num[tl.get(x)]
              while (y < al2.size() && num[al2.get(y)] == num[al2.get(y - 2)]) {
                y = y + 2;
              }
            } else {
              y = y + 2;
            }
          }
          x = x + 2;
          while (x < al1.size() && num[al1.get(x)] == num[al1.get(x - 2)]) {
            x = x + 2;
          }

        }

      }          
        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }


    return result;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] num = { 3,-4,-1,0,-3,5,6,0,-5,-9,8,-9 };
    FourSum so = new FourSum();
    System.out.println(so.foursum_hashMap(num, -2));
    System.out.println(so.foursum(num, -2));
  }

}
