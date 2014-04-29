import shared.TreeNode;


public class ConstructBinaryTreefromInorderandPostorderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0)
      return null;

    TreeNode root = build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);

    return root;
  }
  private TreeNode build(int[] postorder, int startP, int endP, int[] inorder, int startIn, int endIn) {
    // TODO Auto-generated method stub
    if (startP > endP || startIn > endIn)
      return null;

    TreeNode root = new TreeNode(postorder[endP]);
    int i = startIn;
    while (i <= endIn && inorder[i] != postorder[endP]) {
      i++;
    }
    
    root.left = build(postorder,startP,startP+i-startIn-1,inorder,startIn,i-1);
    root.right = build(postorder,startP+i-startIn,endP-1,inorder,i+1,endIn);

    return root;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
