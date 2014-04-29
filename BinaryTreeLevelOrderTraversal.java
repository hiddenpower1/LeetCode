import shared.TreeNode;
import java.util.ArrayList;


public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (root==null){
    		return result;
    	}
    	ArrayList<TreeNode> current = new ArrayList<TreeNode>();
    	ArrayList<TreeNode> next = new ArrayList<TreeNode>();
    	
    	current.add(root);
    	
    	while(!current.isEmpty()){
    		ArrayList<Integer> level = new ArrayList<Integer>();
    		for(int i=0;i<current.size();i++){
    			level.add(current.get(i).val);
    			if(current.get(i).left!=null)
    				next.add(current.get(i).left);
    			if(current.get(i).right!=null)
    				next.add(current.get(i).right);
    		}
    		
    		result.add(level);
    		ArrayList<TreeNode> temp = current;
    		current =  new ArrayList<TreeNode>(next);
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
