class LRUCache {
    private Node head; 
    private Node tail;
    private HashMap<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
       this.head = new Node(); 
       this.tail = this.head;
       this.map  = new HashMap<>();
       this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node node = map.get(key);

        // removing from the linked list
        node.previous.next = node.next;
        if(node.next!=null)node.next.previous = node.previous;
        else this.tail = node.previous;

        // adding it at the end  
        this.tail.next = node;
        node.next =null;
        node.previous = this.tail;
        this.tail = node;

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;

            // remove from linked list
            node.previous.next = node.next;
            if(node.next != null) node.next.previous = node.previous;
            else this.tail = node.previous;
        }
        else{
            if(this.map.size() == this.capacity){
                Node toRemove = this.head.next;
                map.remove(toRemove.key);
                this.head.next = toRemove.next;
                if(this.head.next != null) this.head.next.previous = this.head;
                else this.tail = this.head;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
        }
        // adding it at the end  
        Node node = map.get(key);
        this.tail.next = node;
        node.next =null;
        node.previous = this.tail;
        this.tail = node;

    }
}

class Node{
    int key;
    int val;
    Node next;
    Node previous;

    public Node(){
        this.val =0;
        this.next = null;
        this.previous = null;
    }

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
