import shared.ListNode;

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists (ListNode l1,ListNode l2){
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

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
