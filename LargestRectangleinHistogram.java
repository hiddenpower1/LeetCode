import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistogram {
  public int largestRectangleArea(int[] height) {
    
    Stack<ArrayList<Integer>> st = new Stack<ArrayList<Integer>>();
    int max = 0;
    
    for(int i = 0;i<height.length;i++){
      if(st.isEmpty() || height[i]>st.peek().get(1)){
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(0,i);
        cur.add(1, height[i]);
        st.push(cur);
      }else{
        //current bar's height smaller than the top of the stack
        //pop the stack till the top is smaller than current bar. while calc the area during pop 
        int lastindex = 0;
        while(!st.isEmpty() && height[i] < st.peek().get(1)){
          ArrayList<Integer> bar = st.pop();
          lastindex = bar.get(0);
          int area = (i-lastindex)*bar.get(1);
          if(max<area)
            max = area;
        }
        
        //cur height == stack top, ignore
        if(!st.isEmpty() && height[i] == st.peek().get(1))
          continue;
        else{
          ArrayList<Integer> cur = new ArrayList<Integer>();
          cur.add(0,lastindex);
          cur.add(1, height[i]);
          st.push(cur);
        }
      }

    }
    
    //calc area till stack is empty
    while(!st.isEmpty()){
      ArrayList<Integer> bar = st.pop();
      int area = (height.length-bar.get(0))*bar.get(1);
      if(max<area)
        max = area;
    }
    
    return max;
    
  }
  
  
  public int largestRectangleArea2(int[] height) {
      Stack<Integer> stack = new Stack<Integer>();
      int i = 0;
      int maxArea = 0;
      int[] h = new int[height.length + 1];
      h = Arrays.copyOf(height, height.length + 1);
      
      while(i < h.length){
          if(stack.isEmpty() || h[stack.peek()] <= h[i]){
              stack.push(i++);
          }else {
              int t = stack.pop();
              maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
          }
      }
      return maxArea;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
