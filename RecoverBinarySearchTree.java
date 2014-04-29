import java.util.Stack;

import shared.TreeNode;


public class RecoverBinarySearchTree {
  public void recoverTree(TreeNode root) {
	    Stack<TreeNode> st = new Stack<TreeNode>();
	    
	    TreeNode node = root;
	    TreeNode pre = null;
	    TreeNode node1 = null;
	    TreeNode node2 = null;
	    
	    while(!st.isEmpty() || node != null){
	    	if(node!=null){
		    	st.push(node);
		    	node = node.left;
		    	
	    	}else{
	            node = st.pop();
	            if(pre!= null && pre.val>node.val){
	            	//first time find wrong order, pre is one of the node misplaced. set cur node as one potential. 
	            	//if we don't find the second place have wrong order. then it will be the other node.
	            	if(node1==null){
	            		node1 = pre;
	            		node2 = node;
	            	}else
	            		// second time find wrong order. current node is one of the node misplaced.
	            		node2 = node;
	            }	            
	            pre = node;
	            node = node.right;
	    	}
	    }
	    
	    int temp = node1.val;
	    node1.val = node2.val;
	    node2.val = temp;
	 
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
