
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n==1 || n == 0)
        	return 1;
        
        int num = 0;
        
        //split into half for each possible root.
        for(int i =1;i<=n;i++){
        	num = num + numTrees(i-1)*numTrees(n-i);
        }
        
        return num;
    	
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
