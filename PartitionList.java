import shared.ListNode;

public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode left = new ListNode(-1);
    ListNode right = new ListNode(-1);
    ListNode lefthead = left;
    ListNode righthead = right;
    
    while(head!=null){
      if(head.val<x){
        left.next=head;
        left = left.next;
      }else{
        right.next = head;
        right = right.next;
      }
      head = head.next;
    }
    
    left.next = righthead.next;
    right.next = null;
    
    return lefthead.next;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
