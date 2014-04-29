import java.util.ArrayList;
import java.util.HashMap;

import shared.UndirectedGraphNode;

public class CloneGraph {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    
    if(node == null)
      return null;
    
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
        new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    ArrayList<UndirectedGraphNode> cur = new ArrayList<UndirectedGraphNode>();
    ArrayList<UndirectedGraphNode> next = new ArrayList<UndirectedGraphNode>();

    UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
    cur.add(node);
    map.put(node, clone);
    
    while(!cur.isEmpty()){
      for(int i=0;i<cur.size();i++){
        //visited.add(cur.get(i));
        UndirectedGraphNode curr = cur.get(i);
        for(int j=0;j<curr.neighbors.size();j++){
          
          UndirectedGraphNode temp = cur.get(i).neighbors.get(j);
          if(!map.containsKey(temp)){
            UndirectedGraphNode worker = new UndirectedGraphNode(temp.label);
            map.put(temp, worker);
            map.get(curr).neighbors.add(worker);
            next.add(temp);
          }else{
            map.get(curr).neighbors.add(map.get(temp));
          }
        }
      }
      
      ArrayList<UndirectedGraphNode> temp = cur;
      cur = next;
      next = temp;
      next.clear();
      
    }
    
    return clone;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
