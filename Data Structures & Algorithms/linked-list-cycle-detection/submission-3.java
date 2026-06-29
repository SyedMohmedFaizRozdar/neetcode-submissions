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
    public boolean hasCycle(ListNode head) {
        if(head== null || head.next == null) return false;
        ListNode turtle = head;
        ListNode hare = head;

        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;

            if(turtle == hare) return true;
            
        }

        return false;
    }
}
