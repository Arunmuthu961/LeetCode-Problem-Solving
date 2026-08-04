import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    // Node class for the doubly linked list
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head and tail nodes to avoid edge cases
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        moveToHead(node); // Mark as most recently used
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // Update value
            moveToHead(node);   // Mark as most recently used
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            
            // Check capacity constraint
            if (map.size() > capacity) {
                Node lruNode = removeTail(); // Remove from linked list
                map.remove(lruNode.key);     // Remove from hashmap
            }
        }
    }
    
    // Helper to add a node right after the dummy head
    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    // Helper to remove an existing node from the linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Helper to move a node to the front (most recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    // Helper to remove the least recently used node (just before dummy tail)
    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}
