import java.util.ArrayList;
import java.util.Stack;

import shared.TreeNode;


public class BinaryTreePreorderTraversal {
  public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> order = new ArrayList<Integer>();
    Stack<TreeNode> st = new Stack<TreeNode>();
    
    TreeNode node = root;
    //st.push(node);
    
    while(!st.isEmpty() || node!=null){
      if(node!=null){
        order.add(node.val);
        st.add(node);
        node = node.left;
      }else{
        node = st.pop();
        node = node.right;
      }

    }
    
    return order;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
