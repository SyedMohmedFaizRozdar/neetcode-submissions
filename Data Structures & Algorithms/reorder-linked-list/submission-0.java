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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        ListNode tail = head2;
        while(tail != null && tail.next != null){
            tail = tail.next;
        }

        reverseList(head2);

        ListNode temp1 = head;
        ListNode temp2 = tail;

        while(temp1 != null && temp2 != null){
            ListNode nextNode1 = temp1.next;
            ListNode nextNode2 = temp2.next;

            temp1.next = temp2;
            temp2.next = nextNode1;

            temp1 = nextNode1;
            temp2 = nextNode2;
        }
    }

    public void reverseList(ListNode head){
        if(head == null || head.next == null) return;

        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head.next;

        while(nextNode != null){
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }

        currNode.next = prevNode;

        head = currNode;
    }
}
