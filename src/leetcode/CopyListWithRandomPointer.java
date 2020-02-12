package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
        //I should come up with a mapping from oldNode -> newNode
        //hash(oldNode) -> newNode
        Map<Integer, Node> map = new HashMap<>();
        
        //iterate head and create a mapping of newNodes, 
        //also updating the next pointer
        Node currentOld = head;
        
        Node prevNew = null;
        Node newHead = null;
        
        while (currentOld != null) {
            Node newNode = new Node(currentOld.val);
            map.put(currentOld.hashCode(), newNode);
            
            if (prevNew != null) {
                prevNew.next = newNode;
            } else {
                newHead = newNode;
            }
            
            prevNew = newNode;
            currentOld = currentOld.next;
        }
        
        currentOld = head;
        Node currentNew = newHead;
        while (currentOld != null) {
            if (currentOld.random != null) {
                Node newRandom = map.get(currentOld.random.hashCode());
                currentNew.random = newRandom;
            }
            currentOld = currentOld.next;
            currentNew = currentNew.next;
        }
        
        return newHead;
    }
	
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
}
