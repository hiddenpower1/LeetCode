import shared.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
        	return true;
        
        if(root.left ==null || root.right == null){
        	return root.left == root.right;
        }
        
        return root.left.val == root.right.val && isSymmetric(root.left,root.right);
        
    }
    
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if(left == null && right == null)
			return true;
		
        if(left!=null && right!=null){
        	return (left.val == right.val)&&isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        }
        
        return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
