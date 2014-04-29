import java.util.ArrayList;
import java.util.HashMap;


public class LRUCache {
  public ArrayList<Integer> keys;
  public HashMap<Integer,Integer> hm;
  public int maxcap;
  public int curcap;
  
  public LRUCache(int capacity) {
    this.maxcap = capacity;
    hm = new HashMap<Integer,Integer> ();
    keys = new ArrayList<Integer>();
    curcap = 0;
  }
  
  //when get need set that key to most recent.
  public int get(int key) {
    if(hm.containsKey(key)){
      int pos = keys.indexOf(key);
      keys.remove(pos);
      keys.add(key);
      return hm.get(key);
    }else
      return -1;
      
  }
  
  public void set(int key, int value) {
    if(hm.containsKey(key)){
      hm.put(key, value);
      int pos = keys.indexOf(key);
      keys.remove(pos);
      keys.add(key);
    }else{
      if(curcap == maxcap){
        hm.remove(keys.get(0));
        keys.remove(0);
      }else{
        curcap++;
      }
      keys.add(key);
      hm.put(key, value);
    }
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
