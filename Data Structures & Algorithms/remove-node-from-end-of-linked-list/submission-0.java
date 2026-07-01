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
            head = reverseList(head);
 
            int i=2;
            ListNode temp = head;
            ListNode prev = null;
 
            while(i<n){
                prev = temp;
                temp = temp.next;
                i++;
            }

            if(temp == head && n == 1){
                head = temp.next;
                temp.next = null;
            }else if(temp.next == null){
                prev.next = null;
            }else{
                temp.next = temp.next.next;
            }

            return reverseList(head);
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
 
        ListNode prev = null;
        ListNode curr = head;
 
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
 
        return prev;
    }
}