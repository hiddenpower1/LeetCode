import shared.ListNode;

public class RemoveDuplicatesfromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    
    if(head == null || head.next == null){
      return head;
    }
    
    ListNode runner = head;
     
    while(runner.next!=null){
      if(runner.val == runner.next.val)
        runner.next = runner.next.next;
      else
        runner = runner.next;
    }
    
    return head;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
