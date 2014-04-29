import java.util.ArrayList;

import shared.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {
  public void connect(TreeLinkNode root) {
    //level order travese, but require more than constant space
    if(root == null)
      return;
    
    ArrayList<TreeLinkNode> cur = new ArrayList<TreeLinkNode>();
    ArrayList<TreeLinkNode> next = new ArrayList<TreeLinkNode>();
    
    cur.add(root);
    
    while(!cur.isEmpty()){
      for(int i=0;i<cur.size();i++){
        if(i!=cur.size()-1)
          cur.get(i).next = cur.get(i+1);
        else
          cur.get(i).next = null;
        
        if(cur.get(i).left!=null)
          next.add(cur.get(i).left);
        if(cur.get(i).right!=null)
          next.add(cur.get(i).right);
        
      }
      
      ArrayList<TreeLinkNode> temp = cur;
      cur = next;
      next = temp;
      next.clear();
      
    }

  }
  
  public void connect_dfs(TreeLinkNode root) {
    if(root == null)
      return;
    
    //left child not null, means still have next level
    if(root.left!=null){
      root.left.next = root.right;
      //is root the last node on current level, if yes, then root.right.next is null,
      // other wise point to next node's left
      root.right.next = root.next == null?null:root.next.left;
      connect_dfs(root.left);
      connect_dfs(root.right);
    }
    
    
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
