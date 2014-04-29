import shared.ListNode;

public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    
    ListNode pre = new ListNode(-1);
    pre.next = head;
    ListNode tail = head;
    ListNode result = pre;

    //pre point to previous posotion of m
    while(m>1){
      pre = pre.next;
      m--;
    }
    
    //tail point to postion n;
    while(n>0){
      tail = tail.next;
    }
    
    ListNode runner = pre.next;
    pre.next = tail;
    pre = tail.next;
    while(pre!=tail){
      ListNode temp = runner.next;
      runner.next=pre;
      pre = runner;
      runner = temp;
    }
    
    return result.next;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
