import java.util.Stack;

public class LongestValidParentheses {
  public int longestValidParentheses(String s) {
    int length = s.length();
    int last = -1;
    int max = 0;
    Stack<Integer> st = new Stack<Integer> ();
    
    for(int i = 0;i<length;i++){
      if(s.charAt(i) == '('){
        st.push(i);
        
      }else{
        if(st.isEmpty()){
          // record the position before first left parenthesis
          last = i;
        }else{
          st.pop();
          //if after pop the stack is empty, the possible start point is last. else, from the position from the top of the stack.
          max = Math.max(max, st.isEmpty()?i-last:i-st.peek());
        }
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
