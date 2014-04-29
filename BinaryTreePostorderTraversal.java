import java.util.ArrayList;
import java.util.Stack;

import shared.TreeNode;


public class BinaryTreePostorderTraversal {
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> order = new ArrayList<Integer>();
    
    TreeNode node = root;
    Stack<TreeNode> st = new Stack<TreeNode>();
    TreeNode last = null;
    
    while(!st.isEmpty() || node != null){
      if(node!=null){
        st.push(node);
        node = node.left;
      }else{
        TreeNode peek = st.peek();
        if(peek.right !=null && last != peek.right){
          /* if right child exists AND traversing node from left child, move right */
          node = peek.right;
        }else{
          st.pop();
          order.add(peek.val);
          last = peek;
        }
      }
    }
    
    return order;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
