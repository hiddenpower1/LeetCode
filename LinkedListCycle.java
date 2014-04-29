import shared.ListNode;


public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    ListNode runner = head;
    ListNode catcher = head;
    
    while(runner!=null&&runner.next!=null){
      runner = runner.next.next;
      catcher = catcher.next;
      if(runner == catcher)
        return true;
    }
    
    return false;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
