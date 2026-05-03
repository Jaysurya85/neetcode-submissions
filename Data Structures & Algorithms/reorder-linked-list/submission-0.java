/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode findMid(ListNode head){
        ListNode faster = head;
        ListNode slower = head;
        while(faster!=null && faster.next!=null){

            slower = slower.next;
            faster = faster.next;

            if(faster!=null){
                faster = faster.next;
            }
        }
        return slower;
    }

    public ListNode rearrange(ListNode head){
        ListNode fixedHead = new ListNode();
        ListNode current  = head;
        while(current!=null){
            ListNode temp = fixedHead.next;
            fixedHead.next = current;
            current = current.next;
            fixedHead.next.next = temp;
        }
        return fixedHead.next;
    }


    public void combine(ListNode head, ListNode head2){
        ListNode current = head;
        ListNode current2 = head2;
        while(current!=null && current2!=null){
            ListNode temp = current.next;
            current.next = current2;
            current2 = current2.next;
            current.next.next = temp;
            current = temp;
        }
    }

    public void reorderList(ListNode head) {

        // find the mid
        ListNode mid = findMid(head);
        System.out.println(mid.val);

        // make another linked list from the mid
        ListNode head2 = mid.next;
        mid.next= null;
        head2 = rearrange(head2);

        // combine both of them 
        combine(head,head2);
    }
}
