import shared.ListNode;

public class SwapNodesinPairs {
  public ListNode swapPairs(ListNode head) {
    if(head==null || head.next == null)
      return head;
    
    ListNode result = new ListNode(-1);
    result.next = head;

    ListNode l1 = result;
    ListNode l2 = head;
    
    while(l2!=null && l2.next!=null){
      //swap
      l1.next = l2.next;
      l1 = l1.next;
      l2.next = l1.next;
      l1.next = l2;
      //move l1 and l2 for next pairs
      l1 = l2;
      l2 = l2.next;
    }
    
    return result.next;
    
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
