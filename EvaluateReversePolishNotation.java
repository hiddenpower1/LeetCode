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
  
  public int evalRPN2(String[] tokens) {

    Stack<Integer> st = new Stack<Integer>();
    HashSet<String> hs = new HashSet<String>();
    hs.add("+");
    hs.add("-");
    hs.add("*");
    hs.add("/");
    
    for(int i = 0;i<tokens.length;i++){
        if(hs.contains(tokens[i])){
            int b = st.pop();
            int a = st.pop();
            int result = calc(a,b,tokens[i]);
            st.push(result);
        }else{
            int a = getInt(tokens[i]);
            st.push(a);
        }
    }
    if(st.size()==1)
        return st.pop();
    else
        return Integer.MIN_VALUE;
}

private int calc(int a,int b,String op){
    if(op.equals("+"))
        return a+b;
    if(op.equals("-"))
        return a-b;
    if(op.equals("*"))
        return a*b;
    if(op.equals("/"))
        return a/b;
    
    return 0;
}

private int getInt(String s){
    if(s.length()==0)
        return 0;
    int result = 0;
    for(int i = 0;i<s.length();i++){
        result = result*10+(s.charAt(i)-'0');
    }
    return result;
}


  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String[] tokens = {"3","-4","+"};
    EvaluateReversePolishNotation so = new EvaluateReversePolishNotation();
    System.out.print(so.evalRPN2(tokens));
  }

}
