import shared.ListNode;


public class LinkedListCycleII {
  public ListNode detectCycle(ListNode head) {
    ListNode runner = head;
    ListNode catcher = head;
    
    while(runner!=null&&runner.next!=null){
      runner = runner.next.next;
      catcher = catcher.next;
      if(runner == catcher){
        runner = head;
        while(runner!=catcher){
          runner = runner.next;
          catcher = catcher.next;
        }
        return runner;
          
      }
    }
    
    return null;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
