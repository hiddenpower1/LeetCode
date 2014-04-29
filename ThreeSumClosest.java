import java.util.Arrays;


public class ThreeSumClosest {
  public int threeSumClosest(int[] num, int target) {
    
    Arrays.sort(num);
    int closest = num[0]+num[1]+num[num.length-1]-target;

    for (int i = 0;i<num.length-2;i++){
      if (i == 0 || num[i]!=num[i-1]){
        int head = i+1;
        int tail = num.length-1;
        
        while (head<tail){
          int temp = num[i] + num[head] + num[tail] - target;
          if (temp == 0)
            return target;
          
          if (Math.abs(temp)<=Math.abs(closest)){
            closest = temp;
            if(temp<0)
              head++;
            else
              tail--;
          }else{
            if (temp < -Math.abs(closest))
                head++;
            else
              tail--;
          }
            
          
        }
        
        
      }
    }
    
    return closest + target;
    
  }
}
