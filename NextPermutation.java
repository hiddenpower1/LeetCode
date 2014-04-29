public class NextPermutation {
  public void nextPermutation(int[] num) {
    
    int size = num.length;
    if (size == 0 || size == 1) {
      return;
    }

    // from end find the first ascending pair
    for (int i = size - 2; i >= 0; i--) {
      if (num[i] < num[i + 1]) {
        int j = i + 1;
        //find the index where current num[i] need to be placed to
        for (; j < size; j++) {
          if (num[i] >= num[j]) {
            break;
          }
        }
        int temp = num[i];
        num[i] = num[j - 1];
        num[j - 1] = temp;
        //after swap. from i+1 to end is in descending order, need reverse.
        reverse(num, i + 1);
        return;
      }
    }
    reverse(num, 0);
    return;

  }

  private void reverse(int[] num, int start) {
    // TODO Auto-generated method stub
    int end = num.length - 1;
    int temp;
    while (start < end) {
      temp = num[start];
      num[start] = num[end];
      num[end] = temp;
      start++;
      end--;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
