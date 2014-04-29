
public class BestTimetoBuyandSellStockII {
  public int maxProfit(int[] prices) {
    if(prices.length<2)
      return 0;
    
    int max = 0;
    for(int i=1;i<prices.length;i++){
      if(prices[i]>prices[i-1])
        max = max+prices[i]-prices[i-1];
    }
    
    return max;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
