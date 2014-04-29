import java.util.Arrays;


public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0)
        	return false;
        
        //if string are the same, is Scramble
        if(s1.equals(s2))
        	return true;
        
        //if isScramble, then the string after sort should be the same.
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        String temp1 = new String(ss1);
        String temp2 = new String(ss2);
        if(!temp1.equals(temp2))
        	return false;
        
        
        //check substrings for all possible binary tree representation.
        for(int i = 1;i<s1.length();i++){
        	if((isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))||
        			(isScramble(s1.substring(0,i),s2.substring(s2.length()-i)) && isScramble(s1.substring(i),s2.substring(0,s2.length()-i))))
        		return true;
        }
        
        return false;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString so = new ScrambleString();
		System.out.print(so.isScramble("ab", "ba"));
	}

}
