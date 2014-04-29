import java.util.HashMap;
public class RomantoInteger {
  public int romantoInteger(String roman){
    int[] base = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    String[] rome = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    
    HashMap <String,Integer> map = new HashMap <String,Integer>();
    for(int i=0;i<base.length;i++){
      map.put(rome[i], base[i]);
    }
    
    int result = 0;
    int i = 0;
    
    while(i<roman.length()){
      //check first two character
      if(i<roman.length()-1 && map.containsKey(roman.substring(i, i+2))){
        result = result + map.get(roman.substring(i, i+2));
        i = i+2;
      }else{
        if(map.containsKey(roman.substring(i, i+1))){
          result = result + map.get(roman.substring(i, i+1));
          i=i+1;
        }else{
          //invalid
          return -1;
        }
      }
    }
    
    return result;
    
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
