
public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if(gas.length == 0)
      return -1;
    int[] diff = new int[gas.length];
    
    for(int i = 0;i<gas.length;i++){
      diff[i] = gas[i] - cost[i];
    }
    
    int start = 0;
    int leftgas = 0;
    int sum = 0;
    for(int i = 0;i<gas.length;i++){
      leftgas = leftgas+diff[i];
      sum = sum+diff[i];
      //if sum<0, means from current start will not work.
      //set start to next station.
      if(sum<0){
        start = i+1;
        sum = 0;
      }
    }
    
    if(leftgas < 0)
      return -1;
    else
      return start;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
