
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())
        	return false;
        
        if(s1.length()==0 || s2.length() == 0){
        	return s3.equals(s1) || s3.equals(s2);
        }
        while(s3.length()>0){
        	if(s3.charAt(0) == s1.charAt(0) && s3.charAt(0)== s2.charAt(0))
        		return isInterleave(s1.substring(1),s2,s3.substring(1)) || isInterleave(s1,s2.substring(1),s3.substring(1));
        	else{
        		if(s3.charAt(0) == s1.charAt(0) || s3.charAt(0) == s2.charAt(0)){
        			return s3.charAt(0) == s1.charAt(0)? isInterleave(s1.substring(1),s2,s3.substring(1)): isInterleave(s1,s2.substring(1),s3.substring(1));
        		}else{
        			return false;
        		}
        	}
        }
        
        return false;
    }
    
    public boolean isInterleave_dp(String s1, String s2, String s3) {
    	//DP
      if(s1.length()+s2.length() != s3.length())
        return false;
      
      int m = s1.length();
      int n = s2.length();
      // match[i][j] means S1 substring(0, i) and S2 substring(0,j) match S3 substring(0,i+j)

      boolean[][] match = new boolean[m+1][n+1];
      match[0][0] = true;
      
      for(int i = 1;i<=m;i++){
        if(s1.charAt(i-1) == s3.charAt(i-1)){
          match[i][0] = match[i-1][0];
        }
      }
      
      for(int i = 1;i<=n;i++){
        if(s2.charAt(i-1) == s3.charAt(i-1)){
          match[0][i] = match[0][i-1];
        }
      }
      
      for(int i=1;i<=m;i++){
        for(int j = 1;j<=n;j++){
          match[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && match[i-1][j]) || 
              (s2.charAt(j-1) == s3.charAt(i+j-1) && match[i][j-1]);
        }
      }
      
      return match[m][n];
    }

    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString so = new InterleavingString();
		System.out.print(so.isInterleave("aabcc","dbbca","aadbbbaccc"));
	}

}
