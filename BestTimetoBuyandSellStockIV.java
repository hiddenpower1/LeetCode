public class BestTimetoBuyandSellStockIV {
  public int maxProfit(int k, int[] prices) {
    int len = prices.length;
    if (len < 2)
      return 0;

    // means same as best time II, you can at most perform n/2 trans
    if (k > len / 2) {
      return quickMax(prices);
    }

    int[][] gmax = new int[len][k + 1];
    int[][] lmax = new int[len][k + 1];

    for (int i = 1; i < len; i++) {
      int diff = prices[i] - prices[i - 1];
      for (int j = 1; j <= k; j++) {
        lmax[i][j] = Math.max(gmax[i - 1][j - 1] + Math.max(0, diff), lmax[i - 1][j] + diff);
        gmax[i][j] = Math.max(gmax[i - 1][j], lmax[i][j]);
      }
    }

    return gmax[len - 1][k];

  }

  private int quickMax(int[] prices) {
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1])
        max += prices[i] - prices[i - 1];
    }

    return max;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
