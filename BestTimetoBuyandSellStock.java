public class BestTimetoBuyandSellStock {
  public int maxProfit(int[] prices) {
    if (prices.length < 2)
      return 0;

    int max = 0;
    int low = prices[0];
    int high = prices[0];
    for (int i = 1; i < prices.length; i++) {
      //current prices higher than high, then calc max
      if (prices[i] > high)
        max = max >= prices[i] - low ? max : prices[i] - low;
      
      //current prices lower than low, set the new low, reset high. 
        //because you can't sell before buy.
      if (prices[i] < low) {
        low = prices[i];
        high = prices[i];
      }
    }

    return max;

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
