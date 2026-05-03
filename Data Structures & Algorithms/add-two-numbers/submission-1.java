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

    public ListNode numberToNode(int number){
        ListNode head = new ListNode();
        ListNode current = head;
        if(number==0){
            return new ListNode(0);
        }
        while(number>0){
            current.next = new ListNode(number%10);
            number /=10;
            current = current.next;
        }
        return head.next;
    }

    public int nodeToNumber(ListNode head){
        int ans =0;
        int mul = 1;
        ListNode current = head;
        while(current!=null){
            ans = ans + current.val*mul;
            current = current.next;
            mul *=10;
        }
        return ans;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //convert the listNode to numbers
        int first = nodeToNumber(l1);
        int second = nodeToNumber(l2);
        int ans = first+second;
        // add and convert back to listNode
        return numberToNode(ans);

    }
}
