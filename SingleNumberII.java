
public class SingleNumberII {
    public int singleNumber(int[] A) {
        if(A.length <= 3)
        	return A[0];
        
        int[] bits = new int[32];
        int num = 0;

        for(int i = 0;i<32;i++){
        	int bit = 1<<i;
        	int count = 0;
        	for(int j=0;j<A.length;j++){
        		int temp = bit & A[j];
        		if (temp != 0)
        			count++;
        	}
        	if( count%3 != 0 )
        		bits[i] = 1;
        	else
        		bits[i] = 0;
        	num = num|(bits[i]<<i);
        }
        
        
        return num;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		SingleNumberII so = new SingleNumberII();
		System.out.print(so.singleNumber(A));
	}

}
