import shared.ListNode;
import shared.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
  public TreeNode sortedListToBST(ListNode head) {
	  
	  if(head ==null){
		  return null;
	  }
	  
	  ListNode runner = head;
	  
	  int length = 0;
	  while(runner!= null){
		  runner = runner.next;
		  length++;
	  }
	  
	  if(length == 1){
		  return new TreeNode(head.val);
	  }else{
		  
		  runner = head;
		 for(int i =0;i<(length/2)-1;i++){
			 runner = runner.next;
		 }
		 TreeNode root = new TreeNode(runner.next.val);
		 
		 root.right =  sortedListToBST(runner.next.next);
		 runner.next = null;
		 root.left = sortedListToBST(head);
		 return root;
	  }
	 

	 
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
