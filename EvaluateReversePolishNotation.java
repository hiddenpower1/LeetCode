import java.util.HashSet;
import java.util.Stack;

public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {

    
    Stack<String> st = new Stack<String>();
    HashSet<String> hs = new HashSet<String>();
    hs.add("+");
    hs.add("-");
    hs.add("*");
    hs.add("/");
    
    
    for(int i=0;i<tokens.length;i++){
      if(hs.contains(tokens[i])){
        if(st.size()<2)
          return Integer.MIN_VALUE;
        else{
          //note the first int get push first, so will be the later one get pop out.
          int num2 = Integer.parseInt(st.pop());
          int num1 = Integer.parseInt(st.pop());
          switch(tokens[i]){
            case "+":
              st.push(String.valueOf(num1+num2));
              break;
            case "-":
              st.push(String.valueOf(num1-num2));
              break;
            case "*":
              st.push(String.valueOf(num1*num2));
              break;
            case "/":
              st.push(String.valueOf(num1/num2));
              break;
            default:
              return Integer.MIN_VALUE;
          }
        }
      }else{
        st.push(tokens[i]);
      }
    }
    
    return Integer.parseInt(st.pop());
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
