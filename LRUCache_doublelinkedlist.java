import java.util.HashMap;


public class LRUCache_doublelinkedlist {
  //public DoubleLinkedListNode nodes;
  public HashMap<Integer,DoubleLinkedListNode> hm = new HashMap<Integer,DoubleLinkedListNode>();
  public int maxcap;
  public int curcap;
  public DoubleLinkedListNode head;
  public DoubleLinkedListNode end;

  
  public LRUCache_doublelinkedlist(int capacity) {
    this.maxcap = capacity;
    curcap = 0;
  }
  
  //when get need set that key to most recent.
  public int get(int key) {
    if(hm.containsKey(key)){
      DoubleLinkedListNode latest = hm.get(key);
      removeNode(latest);
      setLatest(latest);
      return latest.val;
    }else
      return -1;
      
  }
  
  private void setLatest(DoubleLinkedListNode latest) {
    // TODO Auto-generated method stub
    latest.next = null;
    latest.pre = end;
    
    if(end!=null)
      end.next = latest;
    
    end = latest;
    
    //this is the first node been set.
    if(head==null){
      head = latest;
    }
  }

  private void removeNode(DoubleLinkedListNode latest) {
    // TODO Auto-generated method stub
    DoubleLinkedListNode pre = latest.pre;
    DoubleLinkedListNode post = latest.next;
    if(pre!=null){
      pre.next = post;
    }else
      head = post;
      
    if(post !=null){
      post.pre = pre;
    }else{
      end = pre;
    }
    
  }

  public void set(int key, int value) {
    if(hm.containsKey(key)){
      DoubleLinkedListNode latest = hm.get(key);
      latest.val = value;
      removeNode(latest);
      setLatest(latest);
    }else{
      if(curcap == maxcap){
        hm.remove(head.key);
        removeNode(head);
      }else{
        curcap++;
      }
      DoubleLinkedListNode latest = new DoubleLinkedListNode(key,value);
      setLatest(latest);
      hm.put(key, latest);
    }
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class DoubleLinkedListNode {
  public int val;
  public int key;
  public DoubleLinkedListNode pre;
  public DoubleLinkedListNode next;

  public DoubleLinkedListNode(int key, int value) {
      this.val = value;
      this.key = key;
  }
}
