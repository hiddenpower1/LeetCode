import java.util.Arrays;
import java.util.Comparator;


public class LargestNumber {
  public String largestNumber(int[] num) {
    String[] nums = new String[num.length];
    for(int i = 0;i<nums.length;i++){
        nums[i] = Integer.toString(num[i]);
    }
    Arrays.sort(nums,new Comparator<String>(){
        public int compare(String a,String b){
            return (b+a).compareTo(a+b);
        }
    });
    
    StringBuilder sb = new StringBuilder();
    for(int i = 0;i<nums.length;i++){
        sb.append(nums[i]);
    }
    
    int i = 0;
    while(i<sb.length()){
        if(sb.charAt(i) == '0')
            sb.deleteCharAt(0);
        else
            break;
    }
    return sb.length() == 0? "0":sb.toString();
    
}
}
