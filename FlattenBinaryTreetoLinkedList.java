import java.util.Stack;

import shared.TreeNode;

public class FlattenBinaryTreetoLinkedList {
  public void flatten(TreeNode root) {
    //preorder travel and flatten.
    
    if(root == null)
      return;
    
    Stack<TreeNode> st = new Stack<TreeNode>();
    TreeNode node = root;
    while(!st.isEmpty() || node != null){
      if(node!= null){
        st.push(node);
        node = node.left;
      }else{
        node = st.pop();
        if(node.left!=null){
          //put node.left tree between node and node.right;
          TreeNode lastleft = node.left;
          while(lastleft.right!=null){
            lastleft = lastleft.right;
          }
          //4.2.connect right sub tree after left sub tree

          lastleft.right = node.right;
          
          //4.3.move left sub tree to the cur's right sub tree

          node.right = node.left;
          node.left = null;
          node = lastleft.right;
        }else{
          node = node.right;
        }

      }
    }
  }
  
  public void flatten_recursive(TreeNode root) {
    //preorder travel and flatten.
    
    if(root == null)
      return;

    if(root.left!=null)
      flatten_recursive(root.left);
    
    if(root.right!=null)
      flatten_recursive(root.right);
    
    if(root.left!=null){
      TreeNode lastleft = root.left;
      while(lastleft.right!=null)
        lastleft = lastleft.right;
      
      lastleft.right = root.right;
      root.right = root.left;
      root.left = null;
      
    }
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
