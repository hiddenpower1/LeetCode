import java.util.ArrayList;
import shared.TreeNode;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        
        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        
        current.add(root);
        int depth = 1;
        
        while(!current.isEmpty()){
        	for(int i = 0;i<current.size();i++){
        		if(current.get(i).left == null && current.get(i).right == null)
        			return depth;
        		else{
        			if(current.get(i).left != null)
        				next.add(current.get(i).left);
        			if(current.get(i).right != null)
        				next.add(current.get(i).right);
        		}
        	}
        	depth++;
        	ArrayList<TreeNode> temp = current;
        	current = next;
        	next = temp;
        	next.clear();
        }
        
        return depth;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
