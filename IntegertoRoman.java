
public class IntegertoRoman {
  public String integerToRoman(int x){
    int[] base = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    String[] rome = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    
    int remain = x;
    int i = base.length-1;
    String result = "";
    while(i>=0){
      int count = remain/base[i];
      remain = remain - base[i]*count;
      while(count>0){
        result = result+rome[i];
        count--;
      }
      i--;
    }
    return result;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
