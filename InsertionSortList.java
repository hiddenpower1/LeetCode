import shared.ListNode;


public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    if(head == null || head.next == null)
      return head;
    
    ListNode result = new ListNode(-1);
    result.next = head;
    
    ListNode cur = head.next;
    ListNode pre = head;
    while(cur!=null){
      ListNode temp = result;
      //find the location to insert
      while(temp != pre && temp.next.val <= cur.val){
        temp = temp.next;
      }
      
      //temp != pre, means cur node need insert into previous list.
      if (temp != pre){
        pre.next = cur.next;
        cur.next = temp.next;
        temp.next = cur;
        cur = pre.next;
      }else{
        //cur node is the largest in previous list, remain the same position.
        cur = cur.next;
        pre = pre.next;
      }
      
    }
    
    return result.next;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
