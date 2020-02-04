package leetcode;

import java.util.TreeMap;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        TreeMap<Key, ListNode> map = new TreeMap<>();
        int i = 0;
        for (ListNode n: lists) {
            if (n != null) {
                map.put(new Key(n.val, i++), n);
            }
        }
        
        ListNode result = null;
        ListNode last = null;
        
        while(!map.isEmpty()) {
            Key lowestKey = map.firstKey();
            ListNode lowestNode = map.remove(lowestKey);
            
            if (lowestNode.next != null) {
                map.put(new Key(lowestNode.next.val, i++), lowestNode.next);
            }
            
            if (result == null) {
                result = new ListNode(lowestNode.val);
                last = result;
            } else {
                last.next = new ListNode(lowestNode.val);
                last = last.next;
            }
        }
        
        return result;
    }
    
    class Key implements Comparable<Key> {
        int val;
        int idx;
        
        public Key(int v, int i) {
            val = v;
            idx = i;
        }
        
        @Override
        public int compareTo(Key o) {
            if (this.val == o.val) {
                return this.idx - o.idx;
            }
            return this.val - o.val;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            
            Key other = (Key)obj;
            return this.val == other.val;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            
            result = prime * result + idx;
            result = prime * result + val;
            
            return result;
        }
    }
    
    class ListNode {
    		int val;
    		ListNode next;
    		ListNode(int x) { val = x; }
    }
}
