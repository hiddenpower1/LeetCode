import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
  
  
  //using PriorityQueue
  public ListNode mergeKLists2(List<ListNode> lists) {
    if(lists.size() == 0)
        return null;
    if(lists.size() == 1)
        return lists.get(0);
    
    ListNode result = new ListNode(-1);
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
        public int compare (ListNode a,ListNode b){
            return Integer.compare(a.val,b.val);
        }
    });
    
    //init PQ
    for(int i = 0;i<lists.size();i++){
        if(lists.get(i) != null)
            pq.add(lists.get(i));
    }
    
    ListNode cur = result;
    while(!pq.isEmpty()){
        ListNode temp = pq.poll();
        if(temp.next!=null)
            pq.add(temp.next);
        cur.next = temp;
        cur = cur.next;
    }
    
    return result.next;
}

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }


}
