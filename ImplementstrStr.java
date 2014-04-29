
public class ImplementstrStr {
  public String strStr(String haystack, String needle){
    
    //both null , return null
    if(haystack == null || needle == null)
      return null;
    
    int len1 = haystack.length();
    int len2 = needle.length();
    
    //needle is null, always return haystack.
    if (len2 == 0){
      return haystack;
    }
    
    //outter loop, from 0 to len1-len2+1
    for(int i=0;i< len1-len2 +1; i++){
      //for each possible start point, brute force to check if each character match needle  
      int j =0;
      while(j<len2 && haystack.charAt(i+j)==needle.charAt(j)){
        j++;
      //all character match, return substring.
        if(j == len2)
          return haystack.substring(i);
      }
    }
    
    //no needle found in haystack, return null
    return null;
    
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
