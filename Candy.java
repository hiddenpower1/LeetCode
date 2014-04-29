
public class Candy {
    public int candy(int[] ratings) {
        if(ratings.length == 0)
        	return 0;
        
        //count how many children have descending rating to the left and right

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        
        int sum = 0;

        left[0] = 0;
        for(int i = 1;i<ratings.length;i++){
        	if(ratings[i]>ratings[i-1])
        		left[i] = left[i-1]+1;
        	else
        		left[i] = 0;
        }
        
        right[ratings.length-1] = 0;
        for(int i = ratings.length-2;i>=0;i--){
        	if(ratings[i]>ratings[i+1])
        		right[i] = right[i+1]+1;
        	else
        		right[i] = 0;
        }
        
        for(int i = 0;i<ratings.length;i++){
        	sum = sum+Math.max(left[i], right[i])+1;
        }
        
        return sum;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
