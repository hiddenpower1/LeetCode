import shared.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
          return false;
        
        return getPath(root,sum);
    }
	private boolean getPath(TreeNode root, int remain) {
      // TODO Auto-generated method stub
      if(root.left == null && root.right == null) {
        if(root.val == remain)
          return true;
        else
          return false;
      }
      
      //left and right both are not null
      if(root.left!=null && root.right!=null)
        return getPath(root.left,remain-root.val) || getPath(root.right,remain-root.val);
      
      //right or left are null
      return root.right == null?getPath(root.left,remain-root.val):getPath(root.right,remain-root.val);

    }
  /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
