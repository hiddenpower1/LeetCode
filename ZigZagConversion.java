
public class ZigZagConversion {
  public String zigZag(String s,int rows){
    
    if (rows == 1)
      return s;
    
    String result = "";
    int zigSize = 2*rows-2;
    //int nzag = s.length()/nzig+1;
    int index = 0;
    
    for(int i = 0;i<rows;i++){
      for(int j = 0;j< s.length()/zigSize+1; j++){
        index = j*zigSize+i;
        if(index<s.length()){
          result = result + s.charAt(index);
          if(i>0&&i<rows-1 && (j+1)*zigSize - i <s.length()){
            result = result + s.charAt((j+1)*zigSize - i);
          }
        }
        
      }
    }
    
    return result;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
