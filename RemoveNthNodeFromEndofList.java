import shared.ListNode;

public class RemoveNthNodeFromEndofList {
  public ListNode removeNthFromEnd(ListNode head, int n){
    //two ListNode, distance n, when the tail point to end, the head is point to Nth node from the end
    ListNode runner = new ListNode(0);
    runner.next = head;
    ListNode catcher = runner;
    head = catcher;
    
    //runner run n step first;
    for (int i = 0;i<n;i++){
      runner = runner.next;
    }
    
    while(runner.next!=null){
      catcher = catcher.next;
      runner = runner.next;
    }
      
    catcher.next = catcher.next.next;
    
    return head.next;
    
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
