import shared.TreeNode;


public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int height = check(root,0);
        
        if(height<0)
        	return false;
        else
        	return true;
    }
    
	private int check(TreeNode root, int i) {
		// TODO Auto-generated method stub
		if(root == null)
			return i;
		
		int left = check(root.left,i+1);
		int right = check(root.right,i+1);
		
		if (Math.abs(left-right)<=1)
			return Math.max(left, right);
		else
			return -1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
