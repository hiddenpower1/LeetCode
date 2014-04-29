import shared.TreeLinkNode;


public class PopulatingNextRightPointersinEachNodeII {
  public void connect(TreeLinkNode root) {
    if(root == null)
      return;
    
    //left child not null
    if(root.left!=null){
      if(root.right!=null)
        root.left.next = root.right;
      else{
        //no direct right child, find the first node that is not null at the same level.
        TreeLinkNode node = root.next;
        while(node!=null){
          if(node.left!=null){
            node = node.left;
            break;
          }
          if(node.right!=null){
            node = node.right;
            break;
          }
          node = node.next;
        }
        root.left.next = node;
      }

    }
    
    if(root.right!=null){

        //find the first node that is not null at the same level.
        TreeLinkNode node = root.next;
        while(node!=null){
          if(node.left!=null){
            node = node.left;
            break;
          }
          if(node.right!=null){
            node = node.right;
            break;
          }
          node = node.next;
        }
        root.right.next = node;

    }
    
    //recursive call start from right,  Cause, at the parent level, 
    //the next are only keeped for the direct next right node. 
    //So, if the direct next node doesn't have child, the link is break
    connect(root.right);
    connect(root.left);
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
