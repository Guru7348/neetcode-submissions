
class Node {
    int val;
    int key;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    int capacity;
    Set<Integer> numsUsed = new HashSet<>();
    int used = 0;
    Node head = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if (!numsUsed.contains(key)) {
            return -1;
        }

        return reorder(key, -1);
    }

    public void put(int key, int value) {

        if (capacity == 0) return;

        if (!numsUsed.contains(key)) {
            insert(key, value);
        }

        reorder(key, value);
    }

    public void insert(int key, int val) {

        if (used == capacity) {
            removeLast();
        }

        Node newNode = new Node(key, val);

        numsUsed.add(key);

        newNode.next = head;
        head = newNode;

        used++;
    }

    public void removeLast() {

        if (head == null) return;

        if (head.next == null) {
            numsUsed.remove(head.key);
            head = null;
            used--;
            return;
        }

        Node prev = null;
        Node curr = head;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        numsUsed.remove(curr.key);

        prev.next = null;
        used--;
    }

    public int reorder(int key, int val) {

        if (head == null) return -1;

        Node prev = null;
        Node curr = head;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) return -1;

        if (val != -1) {
            curr.val = val;
        }

        if (curr != head) {
            prev.next = curr.next;
            curr.next = head;
            head = curr;
        }

        return curr.val;
    }
}