import shared.TreeNode;

public class BinaryTreeMaximumPathSum {
  //maintain the maxvalue from a sub tree.
  //public static int maxSubTree =Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    if(root == null)
      return 0;
    
    //initial everytime, since online jungle will reset this value.
    int[] max = new int[1];
    max[0] =Integer.MIN_VALUE;
    
    int path = maxPath(root,max);
    
    if (path > max[0])
      return path;
    else
      return max[0];

  }
  
  //find the maxPath to root.
  private int maxPath(TreeNode root,int[] max) {
    // TODO Auto-generated method stub
    if(root == null)
      return 0;
    
    int maxLeft = maxPath(root.left,max);
    int maxRight = maxPath(root.right,max);
    
    int temp = root.val;
    if(maxLeft>0)
      temp = temp+maxLeft;
    if(maxRight>0)
      temp = temp+maxRight;
    
    //update the max of a subtree
    if (max[0]<temp)
      max[0] = temp;
    
    return Math.max(root.val, Math.max(root.val+maxLeft, root.val+maxRight));
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    BinaryTreeMaximumPathSum so = new BinaryTreeMaximumPathSum();
    TreeNode root = new TreeNode(-3);
    System.out.print(so.maxPathSum(root));
  }

}
