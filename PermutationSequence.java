import java.util.ArrayList;


public class PermutationSequence {
  public String getPermutation(int n, int k) {
    
    int total = 1;
    ArrayList<Character> num = new ArrayList<Character>();
    
    //String result = "";
    StringBuilder sb = new StringBuilder();

    //// count store the Factorial of (n-1), (n-1)!
    for(int i = 1;i<=n;i++){
      total = total*i;
      num.add(Character.forDigit(i, 10));
    }
    total = total/n;
    
    int remain = k-1;
    while(num.size()>0){
      int index = remain/total;

      sb = sb.append(num.get(index));
      num.remove(index);
      remain = remain%total;
      total= n>1?total/(n-1):1;
      n--;
    }
    
    return sb.toString();
    
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
