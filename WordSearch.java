
public class WordSearch {
  public boolean exist(char[][] board, String word) {
    if(word.length()==0){
      return false;
    }
    
    if(board.length == 0 || board[0].length == 0){
      return false;
    }
    
    boolean[][] used = new boolean[board.length][board[0].length];
    for(int i = 0;i<board.length;i++){
      for(int j = 0;j<board[0].length;j++){
        if(board[i][j] == word.charAt(0)){
          used[i][j] = true;
          if(find(board,used,i,j,word,1)){
            return true;
          }
          used[i][j] = false;
        }
      }
    }
    
    return false;
  }
  private boolean find(char[][] board, boolean[][] used, int i, int j, String word, int k) {
    // TODO Auto-generated method stub
    if(k==word.length())
      return true;
    
    //check i-1,j
    if(i>0  && !used[i-1][j] && board[i-1][j] == word.charAt(k)){
      used[i-1][j] = true;
      if(find(board,used,i-1,j,word,k+1))
        return true;
      used[i-1][j] = false;
    }
    
    //check i,j-1
    if(j>0 && !used[i][j-1] && board[i][j-1] == word.charAt(k)){
      used[i][j-1] = true;
      if(find(board,used,i,j-1,word,k+1))
        return true;
      used[i][j-1] = false;
    }
    
    //check i+1;j
    if(i<board.length && !used[i+1][j] && board[i+1][j] == word.charAt(k)){
      used[i+1][j] = true;
      if(find(board,used,i+1,j,word,k+1))
        return true;
      used[i+1][j] = false;
    }
    
    //check i,j+1
    if(j<board[0].length && !used[i][j+1] && board[i][j+1] == word.charAt(k)){
      used[i][j+1] = true;
      if(find(board,used,i,j+1,word,k+1))
        return true;
      used[i][j+1] = false;
    }
    
    return false;

  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
