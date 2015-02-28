import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length == 0)
        	return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] height = new int[row][col];
        //save the height of each col using current row as x-axis.
        for(int i = 0;i<row;i++){
        	for(int j = 0; j < col; j++){
        		if(matrix[i][j] == '0'){
        			height[i][j] = 0;
        		}else{
        			if(i==0)
        				height[i][j] = 1;
        			else{
        				height[i][j] = height[i-1][j]+1;
        			}
        		}
        	}
        }
        
        //LargestRectangleinHistogram lr = new LargestRectangleinHistogram();
        int max = 0;
        
        for(int i = 0;i<row;i++){
        	int temp = largestRectangleArea(height[i]);
        	if(max<temp)
        		max = temp;
        }
        
        return max;
    }
    
	private int largestRectangleArea(int[] height) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<Integer>();
		int max = 0;
		
		for(int i = 0;i<height.length;i++){
			if(st.isEmpty() || height[i]>=height[st.peek()]){
				st.push(i);
			}else{
				int lastindex = 0;
				while(!st.isEmpty() && height[st.peek()]>height[i]){
					lastindex = st.pop();
					int temp = (i-lastindex)*height[lastindex];
					if(max<temp){
						max = temp;
					}
				}
				//push lastindex to stack, and change the height of lastindex to height[i]
				st.push(lastindex);
				height[lastindex] = height[i];
			}
		
		}
		
	    //calc area till stack is empty
	    while(!st.isEmpty()){
			int col = st.pop();
			int temp = (height.length-col)*height[col];
			if(max<temp){
				max = temp;
			}
	    }
	    
	    return max;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	


}
