import java.util.HashMap;
import java.util.Stack;


public class ValidParentheses {

  public boolean isValidParentheses(String s) {
    // use stack, left parentheses push, right pop, at the end return true if stack is empty.

    Stack<Character> st = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        st.push(s.charAt(i));
      } else {
        if (!st.isEmpty()) {
          char temp = st.peek();
          if ((temp == '(' && s.charAt(i) == ')') || (temp == '[' && s.charAt(i) == ']')
              || (temp == '{' && s.charAt(i) == '}')) {
            st.pop();
          } else {
            return false;
          }
        }else
          return false;
      }

    }
    
    return st.isEmpty()?true:false;
  }
  
  
  //use hashmap to save the parentheses
  public boolean isValid_hashmap(String s){
    HashMap <Character,Character> hs = new HashMap <Character,Character>();
    hs.put('(', ')');
    hs.put('[', ']');
    hs.put('{', '}');
    
    Stack<Character> st = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      if(hs.containsKey(s.charAt(i))){
        st.push(s.charAt(i));
      }else{
        if(!st.isEmpty() && s.charAt(i) == hs.get(st.pop())){
          continue;
        }else{
          return false;
        }
          
      }
    }
    
    return st.isEmpty();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
