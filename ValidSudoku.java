import java.util.HashSet;


public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    
    //int row = board.length;
    //int col = board[0].length;
    
    HashSet<Character> hs =new HashSet<Character> ();
    hs.add('.');
    for (int i=1;i<10;i++){
        //conver 1-9 to character.
        hs.add(Character.forDigit(i, 10));
    }
    
    //check rows
    for(int i = 0;i<board.length;i++){
      char[] row = board[i];
      boolean valid = isValid(row,hs);
      if (valid == false)
        return valid;
    }
    
    //check columns
    for(int i = 0;i<9;i++){
      char[] col = new char[9];
      for(int j = 0;j<9;j++){
        col[j] = board[j][i];
      }
      boolean valid = isValid(col,hs);
      if (valid == false)
        return valid;  
    }
    
    //check square
    for(int i =0;i<9;i=i+3){
      for(int j = 0;j<9;j=j+3){
        char[] square = new char[9];
        for(int row = 0;row<3;row++){
          for(int col = 0;col<3;col++){
            square[row*3+col] = board[i+row][j+col];
          }
        }
        boolean valid = isValid(square,hs);
        if (valid == false)
          return valid;  
      }
    }

    
    return true;
  }
  
  public boolean isValid(char[] arr, HashSet<Character> hs){
    HashSet<Character> temp = new HashSet<Character> (hs);
    for(int i = 0;i<arr.length;i++){
      if(arr[i] !='.'){
        if(temp.contains(arr[i]))
          temp.remove(arr[i]);
        else
          return false;
      }
    }
    
    return true;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
