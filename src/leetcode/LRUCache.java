package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 * 
 * @author diogenes
 *
 */
public class LRUCache {

    private int capacity = 0;
    private Node begin = null; //begin would be our least recently used.
    private Node end = null; //new or latest accessed values are store here.
    private Map<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.begin = new Node();
        this.end = new Node();
        this.begin.next = end;
        this.end.prev = begin;
    }
    
    public int get(int key) {
        Node item = map.get(key);
        if (item == null) {
            return -1;
        } else {
            removeToEnd(item);
            return item.value;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node item = map.get(key);
            item.value = value;
            removeToEnd(item);
        } else {
            if (map.size() < capacity) {
                Node newNode = new Node();
                newNode.value = value;
                newNode.key = key;
                addToEnd(newNode);
                map.put(key, newNode);
            } else {
                //evict begin
                Node itemToEvict = begin.next;
                remove(itemToEvict);
                //evict on Map
                map.remove(itemToEvict.key);

                Node newNode = new Node();
                newNode.value = value;
                newNode.key = key;

                //put new Node on Map
                map.put(key, newNode);

                //put new Node on End
                addToEnd(newNode);
            }
        }
        
    }
    
    private void removeToEnd(Node node) {
        remove(node);
        addToEnd(node);
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    
    private void addToEnd(Node node) {
        node.next = end;
        node.prev = end.prev;
        
        end.prev.next = node;
        end.prev = node;
    }
    
    //A node for our doubled-linked list
    private class Node {
        Node next;
        Node prev;
        Integer key;
        Integer value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */