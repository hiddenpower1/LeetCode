import java.util.ArrayList;
import java.util.Stack;

import shared.TreeNode;


public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
    	if (root==null){
    		return 0;
    	}
    	
    	ArrayList<TreeNode> current = new ArrayList<TreeNode>();
    	ArrayList<TreeNode> next = new ArrayList<TreeNode>();
    	
    	current.add(root);
    	
    	int max = 0;
    	while(!current.isEmpty()){
    		for(int i=0;i<current.size();i++){
    			if(current.get(i).left!=null)
    				next.add(current.get(i).left);
    			if(current.get(i).right!=null)
    				next.add(current.get(i).right);
    		}
    		
    		ArrayList<TreeNode> temp = current;
    		current = next;
    		next = temp;
    		next.clear();
    		max++;
    		
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
