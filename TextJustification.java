import java.util.ArrayList;


public class TextJustification {
  public ArrayList<String> fullJustify(String[] words, int L) {
    
    

    
    ArrayList<String> result = new ArrayList<String>();
//    if(L==0){
//      result.add(words[0]);
//      return result;
//    }
    
    int index = 0;
    
    while(index<words.length){
      int count = 0;
      int currentL = 0;
      while(index<words.length && currentL+ words[index].length()<=L ){
        currentL = currentL+ words[index].length();
        index++;
        count++;
        //add at least one space;
        currentL++;
      }
      
      result.add(justification(words,result,count,index, currentL,L));
    }
    
    return result;
    
  }
  private String justification(String[] words, ArrayList<String> result, int count, int index, int currentL,int L) {
    // TODO Auto-generated method stub

    int totalspace = L - (currentL-count);
    int sharedspace = 0;
    int extraspace = 0;
    if(count>1){
      sharedspace = totalspace/(count-1);
      extraspace = totalspace%(count-1);
    }
    
    StringBuilder sb = new StringBuilder();
    
    if(index == words.length || count == 1){
      //left justification, since it's last line or only one word.
      for(int i = index-count;i<index;i++){
        sb = sb.append(words[i]);
        if(sb.length()<L)
          sb.append(" ");
      }
      //pad space till the end
      while(sb.length()<L){
        sb.append(" ");
      }
      
    }else{
      //normal justification

      for(int i = index-count;i<index-1;i++){
        sb = sb.append(words[i]);
        for(int j = 0;j<sharedspace;j++)
          sb = sb.append(" ");
        //check if need append extra space.
        if(extraspace>0){
          sb = sb.append(" ");
          extraspace--;
        }
      }
      sb = sb.append(words[index-1]);

    }
    
    return sb.toString();
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
