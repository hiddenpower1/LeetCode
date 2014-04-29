import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthofLongestSubstring (String s){
    int longest = 0;
    //int length = 0;
    int head = 0;
    int tail = 0;
    HashSet<Character> hs = new HashSet<Character>();

    while(tail<s.length()){
      if(hs.contains(s.charAt(tail))){
        longest = longest>= tail-head? longest:tail-head;
        //repeated character must have appeared before at an index i, where i is less than j. find the index,
        //remove characters from head to i from the hash set
        while(s.charAt(head)!=s.charAt(tail)){
          hs.remove(s.charAt(head));
          head++;
        }
        //start to look for the next substring with head which starts exactly at index i+1.
        head ++;
        tail ++;   
      }else{
        hs.add(s.charAt(tail));
        tail++;
      }
    }
      
    return longest>= s.length()-head? longest:s.length()-head;
  }
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
    LongestSubstringWithoutRepeatingCharacters so = new LongestSubstringWithoutRepeatingCharacters();
    System.out.print(so.lengthofLongestSubstring(s));
  }

}
