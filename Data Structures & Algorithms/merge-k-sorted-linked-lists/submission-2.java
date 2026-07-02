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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        int step = 1;

        while(step < lists.length){
            for(int i=0; i+step<lists.length; i+=step*2){
                lists[i] = merge2Lists(lists[i],lists[i+step]);
            }
            step *= 2;
        }

        return lists[0];
    }
    public ListNode merge2Lists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        ListNode left = list1;
        ListNode right = list2;

        while(left != null && right != null){
            if(left.val <= right.val){
                ListNode nextNode = left.next;
                temp.next = left;
                temp = temp.next;
                left.next = null;
                left = nextNode;
            }else{
                ListNode nextNode = right.next;
                temp.next = right;
                temp = temp.next;
                right.next = null;
                right = nextNode;
            }
        }

        if(left != null){
            temp.next = left;
        }
        if(right != null){
            temp.next = right;
        }

        return dummy.next;
    }
}
