
public class EditDistance {
  public int minDistance(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    if(l1==0 || l2==0)
      return l1==0? l2:l1;
    
    int[][] distance = new int[l1+1][l2+1];
    
    //s1:0 require s1.length steps
    for(int i = 0 ; i <= l1;i++){
      distance[i][0] = i;
    }
    
    //0:s2 require s2.length steps
    for(int j = 0;j<=l2;j++){
      distance[0][j] = j;
    }
    
    for(int i = 1;i<=l1;i++){
      for(int j = 1;j<=l2;j++){
        if(word1.charAt(i-1) == word2.charAt(j-1)){
          distance[i][j] = Math.min(distance[i-1][j-1], Math.min(distance[i-1][j]+1, distance[i][j-1]+1));
        }else{
          distance[i][j] = Math.min(distance[i-1][j-1]+1, Math.min(distance[i-1][j]+1, distance[i][j-1]+1));
        }
        
      }
    }
    
    return distance[l1][l2];
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
