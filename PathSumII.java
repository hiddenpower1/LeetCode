import java.util.ArrayList;

import shared.TreeNode;


public class PathSumII {
  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if(root == null)
      return result;
    
    ArrayList<Integer> path = new ArrayList<Integer>();
    findPath(root,sum,path,result);
    
    return result;
    
  }
  private void findPath(TreeNode root, int remain, ArrayList<Integer> path,
      ArrayList<ArrayList<Integer>> result) {
    // TODO Auto-generated method stub
    ArrayList<Integer> temp = new ArrayList<Integer>(path);
    temp.add(root.val);
    
    if(root.left==null && root.right == null && root.val == remain){
      
      result.add(temp);
      return;
    }
    
    if(root.left!=null){
      findPath(root.left,remain-root.val,temp,result);
    }
    
    if(root.right!=null){
      findPath(root.right,remain-root.val,temp,result);
    }
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
