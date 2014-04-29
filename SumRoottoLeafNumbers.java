import shared.TreeNode;


public class SumRoottoLeafNumbers {
  public int sumNumbers(TreeNode root) {
    //dfs
    if(root == null){
      return 0;
    }
    
    int[] sum = new int[1];
    sum[0] = 0;
    StringBuffer num = new StringBuffer();
    
    sum(root,sum,num);
    
    return sum[0];
    
  }
  private void sum(TreeNode root, int[] sum, StringBuffer num) {
    // TODO Auto-generated method stub
    num.append(root.val);

    if(root.left==null && root.right==null){
      sum[0] = sum[0] + Integer.parseInt(num.toString());
    }
    
    if(root.left!=null){
      sum(root.left,sum,num);
    }
    
    if(root.right!=null){
      sum(root.right,sum,num);
    }
    
    num.deleteCharAt(num.length()-1);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
