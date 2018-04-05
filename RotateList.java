/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode zero = new ListNode(0);
        zero.next = head;
        int length = 0;
        ListNode fast = zero, slow = zero;
        while (fast.next != null) {
            length++;
            fast = fast.next;
        }

        for (int i = length - (k % length); i > 0; i--) {
            slow = slow.next;
        }
        
        fast.next = zero.next;
        zero.next = slow.next;
        slow.next = null;
        
        return zero.next;
    }
}