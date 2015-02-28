import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


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
  
  
  public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
    Arrays.sort(num);
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    for(int i = 0;i<num.length-2;i++){
      if(i==0 || num[i] != num[i-1])
        twoSum(num,-num[i],i,result);
    }
    
    return result;
}

public void twoSum(int[] numbers, int target,int start , ArrayList<ArrayList<Integer>> result) {
    HashSet<Integer> hs = new HashSet<Integer>();
    for(int i=start+1;i<numbers.length;i++){
        if(hs.contains(numbers[i])){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(-target);
            temp.add(target - numbers[i]);
            temp.add(numbers[i]);
            result.add(temp);
            while(i<numbers.length-1 && numbers[i] == numbers[i+1])
              i++;
        }else{
            hs.add(target-numbers[i]);
        }
    }
}

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] num = {0,0,0};
    ThreeSum so = new ThreeSum();
    so.threeSum2(num);
    System.out.print("end");
  }

}
