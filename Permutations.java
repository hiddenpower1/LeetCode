import java.util.ArrayList;


public class Permutations {
  public ArrayList<ArrayList<Integer>> permute(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> set = new ArrayList<Integer>();
    boolean[] visited = new boolean[num.length];
    permute(num, result, set, visited);
    return result;
  }

  public void permute(int[] num, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> set,
      boolean[] visited) {
    if (set.size() == num.length) {
      result.add(new ArrayList<Integer>(set));
      return;
    }

    for (int i = 0; i < num.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        set.add(num[i]);
        permute(num, result, set, visited);
        set.remove(set.size() - 1);
        visited[i] = false;
      }
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
