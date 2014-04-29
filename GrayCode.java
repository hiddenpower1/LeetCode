import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();

    	if(n<0)
    		return null;
    	
    	//n ==0
    	result.add(0);

    	
    	//n>0
    	int base = 1;
    	for(int i = 1;i<=n;i++){
    		int index = result.size()-1;
    		for(int j=index;j>=0;j--){
    			result.add(result.get(j)+base);
    		}
    		base = base*2;
    	}
    	
    	return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
