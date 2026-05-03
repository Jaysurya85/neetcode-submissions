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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode current = head;
        while(current!=null){
            current = current.next;
            count++;
        }
        count -= n;
        current = head;
        while(count>1){
            current = current.next;
            count--;
        }
        if(count==0)return current.next;
        current.next = current.next.next;
        return head;
    }
}
