import shared.ListNode;

public class AddTwoNumbers {
  
  
  public ListNode addTwoNumbers(ListNode l1,ListNode l2){
    
    ListNode result = new ListNode(0);
    ListNode pointer = result;
    int carry = 0;
    
    while(l1!=null && l2!=null){
      pointer.next = new ListNode((carry+ l1.val+l2.val)%10);
      carry = (carry+ l1.val+l2.val)/10;

      pointer = pointer.next;
      l1 = l1.next;
      l2 = l2.next;
      
    }
    
    while(l1!=null){
      pointer.next = new ListNode((carry+ l1.val)%10);
      carry = (carry+ l1.val)/10;

      pointer = pointer.next;
      l1=l1.next;
    }
    
    while(l2!=null){
      pointer.next = new ListNode((carry+ l2.val)%10);
      carry = (carry+ l2.val)/10;

      pointer = pointer.next;
      l2 = l2.next;
    }
    
    if(carry == 0)
      return result.next;
    else{
      pointer.next  = new ListNode(1);
      return result.next;
    }

  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    

  }

}
