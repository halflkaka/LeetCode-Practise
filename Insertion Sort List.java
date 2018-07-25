/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(head.val);
        ListNode count = head.next;
        while (count != null) {
            ListNode cur = newHead;
            ListNode countCopy = new ListNode(count.val);
            if (count.val < cur.val) {
                countCopy.next = cur;
                newHead = countCopy;
            } else if (cur.next == null) {
                newHead.next = countCopy; 
            } else {
                int flag = 0;
                while (cur.next != null && count.val >= cur.val) {
                    if (count.val < cur.next.val) {
                        countCopy.next = cur.next;
                        cur.next = countCopy;
                        flag = 1;
                        break;
                    }
                    cur = cur.next;
                }
                if (flag == 0) cur.next = countCopy;
            }
            count = count.next;
        }
        return newHead;
    }
}