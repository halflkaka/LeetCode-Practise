/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int length = 0;
        ListNode copyHead = new ListNode(head.val);
        copyHead.next = head.next;
        while (copyHead != null) {
            copyHead = copyHead.next;
            length ++;
        }
        int k = 0;
        copyHead = new ListNode(head.val);
        copyHead.next = head.next;
        if (n == length) {return copyHead.next;}
        while (k < length - n - 1) {
            head = head.next;
            k++;
        }
        head.next = head.next.next;
        if (k == 0) return head;
        return copyHead;
    }
}