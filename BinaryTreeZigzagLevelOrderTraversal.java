import shared.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (root==null){
    		return result;
    	}
    	Stack<TreeNode> current = new Stack<TreeNode>();
    	Stack<TreeNode> next = new Stack<TreeNode>();
    	
    	current.add(root);
    	boolean reverse = false;
    	
    	while(!current.isEmpty()){
    		ArrayList<Integer> level = new ArrayList<Integer>();
    		while(!current.isEmpty()){
    			TreeNode cur = current.pop();
    			level.add(cur.val);
    			if(reverse){
    				//current line is read reverse order, so push right child first
	    			if(cur.right!=null)
	    				next.push(cur.right);
	    			if(cur.left!=null)
	    				next.push(cur.left);
    			}else{
    				//current line is read correct order, push left child first.
	    			if(cur.left!=null)
	    				next.push(cur.left);
	    			if(cur.right!=null)
	    				next.push(cur.right);
    			}
    			
    		}
    		
    		reverse = !reverse;
    		
    		result.add(level);
    		Stack<TreeNode> temp = current;
    		current =  next;
    		next = temp;
    		next.clear();
    	}
    	
    	return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
