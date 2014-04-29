import shared.ListNode;

public class RotateList {
  public ListNode rotateRight(ListNode head, int n) {
    
    if(head == null || head.next == null || n==0)
      return head;
      
    ListNode runner = head;
    int length = 1;
    while(runner.next!=null){
      runner = runner.next;
      length++;
    }
    
    n = n%length;
      
    //rotate n to right is same as rotate length-n to the left.
      ListNode tail = head;
      int count = length-1-n;
      while(count>0){
        tail = tail.next;
        count--;
      }
      runner.next = head;
      runner = tail.next;
      tail.next = null;

    
    return runner;
    
    
    
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
