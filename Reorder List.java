/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        ListNode next = head.next;
        head.next = temp.next;
        temp.next.next = next;
        temp.next = null;
        reorderList(next);
    }
}