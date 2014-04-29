import shared.ListNode;

public class RemoveDuplicatesfromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    
    ListNode result = new ListNode(-1);
    result.next = head;
    
    
    head = result;
    while(head.next!=null){
      ListNode start = head.next;
      ListNode end = start.next;
      if(end!= null && start.val == end.val){
        //
        while(end!=null && start.val == end.val){
          end = end.next;
        }
        head.next = end;
      }else{
        head = start;

      }
    }
    
    return result.next;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
