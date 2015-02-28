import shared.ListNode;


public class ReverseNodesinKGroup {
  
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode result = new ListNode(-1);
    result.next = head;
    
    if(head == null || k == 1){
      return head;
    }
    
    ListNode pre = result;
    ListNode cur = head;
    ListNode start;
    
    while(cur!=null){
      //after the loop, cur will point to the last Node of the current K group.
      for(int i = 1;i<k;i++){
        
        cur = cur.next;
        if(cur==null)
          //left nodes less than k, no reverse.
          return result.next;
      }
      

      start = head;
      pre.next = cur;
      pre = cur.next;
      for(int i = 0;i<k;i++){
          cur = head.next;
          head.next= pre;
          pre = head;
          head = cur;
      }
      pre = start;
      
      
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
