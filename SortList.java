import shared.ListNode;


public class SortList {
  public ListNode sortList(ListNode head) {
    if(head==null || head.next==null)
      return head;
    
    ListNode quick = head;
    ListNode slow = head;
    //find the mid;
    while(quick.next!=null && quick.next.next!=null){
      quick = quick.next.next;
      slow = slow.next;
    }
    quick = slow.next;
    slow.next = null;
    
    //sort first half
    slow = sortList(head);
    //sort second half
    quick = sortList(quick);
    //merge two half
    slow = merge (slow,quick);
    
    return slow;
      
  }
  private ListNode merge(ListNode l1, ListNode l2) {
    // TODO Auto-generated method stub
    ListNode result = new ListNode(-1);
    ListNode pointer = result;
    
    while(l1!=null && l2!=null){
      if(l1.val< l2.val){
        pointer.next = l1;
        pointer = pointer.next;
        l1 = l1.next;
      }else{
        pointer.next = l2;
        pointer = pointer.next;
        l2 = l2.next;
      }
        
    }
    
    if(l1 == null){
      pointer.next = l2;
    }else
      pointer.next = l1;
    
    return result.next;
    
  }
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
