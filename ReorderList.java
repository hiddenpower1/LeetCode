import shared.ListNode;


public class ReorderList {
  public void reorderList(ListNode head) {
    if(head == null || head.next == null)
      return;
    
    ListNode fast = head;
    ListNode slow = head;
    
    //find the mid node and break into two list. slow will point to the end node of first half of the orignal list
    while(fast.next!=null && fast.next.next !=null){
      fast = fast.next.next;
      slow = slow.next;
    }
    
    fast = slow.next;
    slow.next = null;
    //reverse the second half of the list
    fast = reverse(fast);
    slow = head;
    
    //now merge the two list back together.
    while(fast!=null){
      ListNode temp = slow.next;
      slow.next = fast;
      slow = temp;
      temp = fast.next;
      fast.next = slow;
      fast = temp;
    }
    
    
    
  }
  private ListNode reverse(ListNode head) {
    // TODO Auto-generated method stub
    ListNode pre = null;
    ListNode cur = head;
    while(cur!= null){
      ListNode temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;  
    }
    return pre;
  }
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
