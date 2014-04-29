
public class LongestCommonPrefix {
  
  public String commonPrefix(String[] strs){
    String prefix = "";
    
    if (strs.length == 0)
      return "";
    
    for(int i = 0;i<strs[0].length();i++){
      for(int j = 1;j<strs.length;j++){
        if(i>strs[j].length()-1 || strs[0].charAt(i)!=strs[j].charAt(i)){
          return prefix;
        }
      }
      prefix = prefix+strs[0].charAt(i);
    }
    return prefix;
  }
  
  public String commonPrefix_comparePrefix(String[] strs){
    
    if (strs.length == 0)
      return "";
    
    if (strs.length == 1)
      return strs[0];
    
    
    String prefix = strs[0];
    //compare the prefix to next string to form the new prefix.
    for (int i = 1;i<strs.length;i++){
      int j =0;
      while(j<strs[i].length() && j<prefix.length() && prefix.charAt(j)==strs[i].charAt(j)){
        j++;
      }
      prefix = prefix.substring(0,j);
    }
    
    return prefix;
    
    
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
