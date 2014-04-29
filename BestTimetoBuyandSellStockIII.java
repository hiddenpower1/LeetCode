
public class BestTimetoBuyandSellStockIII {
  public int maxProfit(int[] prices) {
    if(prices.length<2)
      return 0;
    
    int max = 0;
    for(int i=0;i<prices.length;i++){
      max = Math.max(max, findMax(0,i,max,prices)+findMax(i+1,prices.length-1,max,prices));
    }
    
    return max;
  }
  private int findMax(int start, int end, int max, int[] prices) {
    // TODO Auto-generated method stub
    if(start>end)
      return 0;
    
    int low = prices[start];
    int high = prices[start];
    for(int i = start;i<=end;i++){
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
  
  
  public int maxProfit_sec(int[] prices) {
    if(prices.length<2)
      return 0;
    
    int[] max = new int[prices.length];
    int low = prices[0];
    max[0] = 0;
    //first round, calc maxProfit for 0 to i;
    for(int i=1;i<prices.length;i++){
      if(prices[i]<low)
        low = prices[i];
      
      max[i] = max[i-1]< (prices[i]-low)? prices[i]-low:max[i-1];
    }
    
    int high = prices[prices.length-1];
    int result = 0;
    //second round, calc maxprofit from i to end, while maintain the final result.
    for(int i=prices.length-2;i>=0;i--){
      if(prices[i]> high)
        high = prices[i];
      
      if(high - prices[i] + max[i] > result)
          result = high - prices[i] + max[i];
    }
    
    return result;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
