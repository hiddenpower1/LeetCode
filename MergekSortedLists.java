import java.util.ArrayList;

import shared.ListNode;


public class MergekSortedLists {
  public ListNode mergeKSortedListes(ArrayList<ListNode> lists){
    
    int n = lists.size();
    if ( n==0)
      return null;
    
    while(n>1){
      int size = (n+1)/2;
      for ( int i = 0;i+size<n;i++){
        lists.set(i, mergeTwoLists(lists.get(i),lists.get(i+size)));
      }
      n=size;
    }
    
    return lists.get(0);
    
  }
  
  
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

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }


}
