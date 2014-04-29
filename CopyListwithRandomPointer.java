import java.util.HashMap;

import shared.RandomListNode;

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return head;
        
		RandomListNode runner = head;
		//first create the new node as next of each node in orignal list
		while(runner!=null){
			RandomListNode temp = new RandomListNode(runner.label);
			temp.next = runner.next;
			runner.next = temp;
			runner = temp.next;
		}
		
		runner = head;
		//then create the random for each of the node for the new list.
		while(runner!=null){
			if (runner.random!=null){
				runner.next.random = runner.random.next;
			}
			runner = runner.next.next;
		}
		
		//then remove the original nodes, and return the remaining as list.
		//be careful we need restore the original list as well.
		
		runner = head;
		RandomListNode newHead = head.next;
		while(runner != null ){
		    RandomListNode temp = runner.next;
		    runner.next = temp.next;
		    runner = temp.next;
		    if(runner!=null)
		    	temp.next = runner.next;
		}
		return newHead;
    }
    
    public RandomListNode copyRandomList_hashmap(RandomListNode head) {
		if(head == null)
			return head;
        
		RandomListNode runner = head;
		HashMap<RandomListNode,RandomListNode> hm = new HashMap<RandomListNode,RandomListNode>();
		//first create the new node as next of each node in orignal list and store in hm
		while(runner!=null){
			RandomListNode temp = new RandomListNode(runner.label);
			hm.put(runner, temp);
			runner = runner.next;
		}
		
		runner = head;
		while(runner!=null){
			if(runner.next!=null)
				hm.get(runner).next = hm.get(runner.next);
			if(runner.random!=null)
				hm.get(runner).random = hm.get(runner.random);
			runner = runner.next;
		}
		
		return hm.get(head);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
