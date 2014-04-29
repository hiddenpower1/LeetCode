import java.util.Set;


public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length()==0 || dict.size()==0)
        	return false;
        
        return find(0,s,dict);
    }
    
	private boolean find(int start, String s, Set<String> dict) {
		// TODO Auto-generated method stub
		if(start==s.length())
			return true;

		for(int i=start+1;i<=s.length();i++){
			if(dict.contains(s.substring(start,i)) && find(i,s,dict)){
				return true;
			}
		}
		
		return false;
	}
	
	
    public boolean wordBreak_DP(String s, Set<String> dict) {
      if(s.length()==0 || dict.size()==0)
          return false;
      
      //Define an array valid[] such that valid[i]==true => 0-(i-1) can be segmented using dictionary

      boolean[] valid = new boolean[s.length()+1];
      //initial state, empty string as true.
      valid[0] = true;
      
      //check each substring, 0-1, 0-2, ... 0-s.length()
      for(int i=1;i<s.length()+1;i++){
        for(int j = 0;j<i;j++){
          valid[i] = valid[j] && dict.contains(s.substring(j, i));
          //when find a valid word break. break out.
          if(valid[i])
            break;
        }
      }
      
      return valid[s.length()];
      
  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
