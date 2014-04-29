import java.util.ArrayList;
import java.util.Collections;

import shared.TreeNode;


public class BinaryTreeLevelOrderTraversalII {
  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if(root == null)
      return result;
    
    ArrayList<TreeNode> current = new ArrayList<TreeNode>();
    ArrayList<TreeNode> next = new ArrayList<TreeNode>();
    
    current.add(root);
    while(!current.isEmpty()){
      ArrayList<Integer> level = new ArrayList<Integer>();
      for(int i = 0;i<current.size();i++){
        if(current.get(i).left!=null)
          next.add(current.get(i).left);
        if(current.get(i).right !=null)
          next.add(current.get(i).right);
        level.add(current.get(i).val);
      }
      
      result.add(level);
      ArrayList<TreeNode> temp = current;
      current = next;
      next = temp;
      next.clear();
    }
    
    Collections.reverse(result);
    return result;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
