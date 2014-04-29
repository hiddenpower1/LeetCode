import java.util.ArrayList;
import java.util.Arrays;


public class ThreeSum {

  public ArrayList<ArrayList<Integer>> threeSum(int[] num) {


    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    //first sort the array
    Arrays.sort(num);

    //for each i , find the possible triplets.
    for (int i = 0; i < num.length - 2; i++) {
      //avoid duplicate
      if (i == 0 || num[i] != num[i - 1]) {

        int head = i + 1;
        int tail = num.length - 1;
        while (head < tail) {

          if (num[i] + num[head] + num[tail] < 0)
            head++;
          else {
            if (num[i] + num[head] + num[tail] > 0)
              tail--;
            else {
              ArrayList<Integer> temp = new ArrayList<Integer>();
              temp.add(0, num[i]);
              temp.add(1, num[head]);
              temp.add(2, num[tail]);
              result.add(temp);
              head++;
              tail--;
              
              //avoid duplicate
              while (head < tail && num[head] == num[head - 1])
                head++;
              while(head<tail && num[tail] == num[tail+1])
                tail--;
            }
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
