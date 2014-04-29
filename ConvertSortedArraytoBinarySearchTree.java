import shared.TreeNode;


public class ConvertSortedArraytoBinarySearchTree {
  public TreeNode sortedArrayToBST(int[] num) {
    TreeNode root = convert(num,0,num.length-1);
    
    return root;
  }
  private TreeNode convert(int[] num, int start, int end) {
    // TODO Auto-generated method stub
    if(start>end)
      return null;
    
    int mid = (start+end)/2;
    TreeNode root = new TreeNode(num[mid]); 
    root.left = convert(num,start,mid-1);
    root.right = convert(num,mid+1,end);
    return root;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
