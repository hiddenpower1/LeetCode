public class DecodeWays {
  public int numDecodings(String s) {
    // DP
    if (s.length() == 0)
      return 0;

    if (s.length() == 1)
      return s.charAt(0) == '0' ? 0 : 1;

    int[] num = new int[s.length()];

    // initiate num[0]
    if (s.charAt(0) == '0')
      return 0;
    else
      num[0] = 1;

    // initiate num[1]
    if (s.charAt(1) == '0') {
      if (s.charAt(0) == '1' || (s.charAt(0) == '2' && Character.digit(s.charAt(1), 10) < 7))
        num[1] = 1;
      else
        return 0;
    } else {
      if (s.charAt(0) == '1' || (s.charAt(0) == '2' && Character.digit(s.charAt(1), 10) < 7))
        num[1] = num[0] + 1;
      else
        num[1] = num[0];
    }


    for (int i = 2; i < s.length(); i++) {

      // if s(i) is valid char alone
      if (s.charAt(i) != '0')
        num[i] = num[i - 1];

      // if s(i)&& s(i-1)together is a valid char as well.

      if (s.charAt(i - 1) == '1'
          || (s.charAt(i - 1) == '2' && Character.digit(s.charAt(i), 10) < 7))
        num[i] = num[i] + num[i - 2];

    }

    return num[s.length() - 1];

  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
