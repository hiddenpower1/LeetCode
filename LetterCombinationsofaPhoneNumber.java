import java.util.ArrayList;


public class LetterCombinationsofaPhoneNumber {
  public ArrayList<String> letterCombinations(String digits){
    ArrayList<String> result = new ArrayList<String>();
    String[] board = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    
    String seq = "";
    generate(digits,0,seq,result,board);
    
    return result;
  }
  
 


  private void generate(String digits, int x, String seq, ArrayList<String> result, String[] board) {
    // TODO Auto-generated method stub
    if (x == digits.length()){
      result.add(seq);
      return;
    }
    
    //recursive
    int number = Character.digit(digits.charAt(x), 10);
    for (int i =0;i<board[number].length();i++){
      generate(digits,x+1,seq+board[number].charAt(i),result,board);
    }
    
  }



  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
