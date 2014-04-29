import shared.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
        	return true;
        
        if(p!=null && q!=null){
        	return (p.val == q.val)&&isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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
