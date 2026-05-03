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
        HashMap<Node,Node> map = new HashMap<>();

        Node newHead = new Node(0);
        Node current = head;
        Node secondCurrent = newHead;

        while(current!=null){
            secondCurrent.next = new Node(current.val);
            secondCurrent = secondCurrent.next;

            map.put(current,secondCurrent);

            current= current.next;
        }
        newHead = newHead.next;
        current = head;
        secondCurrent = newHead;
        while(current!=null){
            if(current.random==null)secondCurrent.random=null;
            else{
                secondCurrent.random = map.get(current.random);
            }
            current = current.next;
            secondCurrent = secondCurrent.next;
        }
        return newHead;
    }
}
