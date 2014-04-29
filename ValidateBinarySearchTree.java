import shared.TreeNode;

public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
  }
  private boolean isValid(TreeNode root, int minValue, int maxValue) {
    // TODO Auto-generated method stub
    if(root == null)
      return true;
    
    if(root.val< maxValue && root.val>minValue){
      return isValid(root.left,minValue,root.val) && isValid(root.right,root.val,maxValue);
    }else
      return false;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
