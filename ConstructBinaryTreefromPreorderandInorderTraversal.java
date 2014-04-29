import shared.TreeNode;


public class ConstructBinaryTreefromPreorderandInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0)
      return null;

    TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    return root;
  }

  private TreeNode build(int[] preorder, int startP, int endP, int[] inorder, int startIn, int endIn) {
    // TODO Auto-generated method stub
    if (startP > endP || startIn > endIn)
      return null;

    TreeNode root = new TreeNode(preorder[startP]);
    int i = startIn;
    while (i <= endIn && inorder[i] != preorder[startP]) {
      i++;
    }
    
    root.left = build(preorder,startP+1,startP+i-startIn,inorder,startIn,i-1);
    root.right = build(preorder,startP+i-startIn+1,endP,inorder,i+1,endIn);

    return root;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ConstructBinaryTreefromPreorderandInorderTraversal so = new ConstructBinaryTreefromPreorderandInorderTraversal();
    int[] pre = {-1};
    int[] in = {-1};
    TreeNode root = so.buildTree(pre, in);
    System.out.print("end");
  }

}
