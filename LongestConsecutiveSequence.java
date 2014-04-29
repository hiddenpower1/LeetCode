import java.util.HashSet;

public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] num) {
    if(num.length<2)
      return num.length;
    
    //save all nums to hashset
    HashSet<Integer> hs = new HashSet<Integer>();
    for(int i=0;i<num.length;i++){
      hs.add(num[i]);
    }
    
    int max = 1;
    //for each num, check if still in the hashset
    for(int i=0;i<num.length;i++){
      //if num in hashset, means the sequence contain this number not being processed yet
      //check num's left and right side for consecutive nums that still in hashset. 
      //when find, length++ and remove it from the hashset.
      if(hs.contains(num[i])){
        hs.remove(num[i]);
        int left = num[i]-1;
        int right = num[i]+1;
        int length = 1;
        //check left side
        while(hs.contains(left)){
          hs.remove(left);
          left--;
          length++;
        }
        //check right side
        while(hs.contains(right)){
          hs.remove(right);
          right++;
          length++;
        }
        //compare current sequence with max sequence.
        if(length>max)
          max = length;
      }
        
    }
    
    return max;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
