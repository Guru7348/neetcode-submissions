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
        Node traverseNode = head;
        while(traverseNode!=null){
            Node clone  = new Node(traverseNode.val);
            clone.next = traverseNode.next;
            traverseNode.next = clone;
            traverseNode = clone.next;
        }
        traverseNode = head;
        while(traverseNode!=null){
            if(traverseNode.random!=null){
                traverseNode.next.random = traverseNode.random.next;
            }
            traverseNode = traverseNode.next.next;
        }
        traverseNode = head;

        Node dummy = new Node(0);
        Node copyList = dummy;

        while(traverseNode!=null){
            Node clone = traverseNode.next;
            copyList.next = clone;
            copyList = clone;
            traverseNode.next = clone.next;
            traverseNode =  traverseNode.next;
        }
        return dummy.next;
    }
}
