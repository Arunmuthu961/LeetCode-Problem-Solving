/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node curr = head;
        
        // Pass 1: Interleave cloned nodes
        while (curr != null) {
            Node nextNode = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = nextNode;
            curr = nextNode;
        }
        
        curr = head;
        // Pass 2: Assign random pointers to the cloned nodes
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Move to the next original node
        }
        
        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;
        
        // Pass 3: Separate the original and cloned lists
        while (curr != null) {
            Node nextOriginal = curr.next.next;
            
            // Extract the copy
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            
            // Restore the original list
            curr.next = nextOriginal;
            
            curr = nextOriginal;
        }
        
        return dummyHead.next;
    }
}
