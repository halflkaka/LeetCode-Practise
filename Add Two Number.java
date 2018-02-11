/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {return null;}
        else if (l1 == null) {
            if (l2.val >= 10) {
                int value = l2.val;
                l2.val = value % 10;
                if (l2.next == null){
                    l2.next = new ListNode(1);
                } else {
                    l2.next.val++;
                }
            }
            l2.next = addTwoNumbers(null,l2.next);
            return l2;
        }
        else if (l2 == null) {
            if (l1.val >= 10) {
                int value = l1.val;
                l1.val = value % 10;
                if (l1.next == null){
                    l1.next = new ListNode(1);
                } else {
                    l1.next.val++;
                }
            }
            l1.next = addTwoNumbers(l1.next,null);
            return l1;
        }
        else {
            int Val = (l1.val + l2.val) % 10;
            int Carry = (l1.val + l2.val) / 10;
            ListNode currentNode = new ListNode(Val);
            if(Carry != 0) {
                if (l1.next != null) {
                    l1.next.val ++;
                } else {
                    l1.next = new ListNode(1);
                }
            } 
            currentNode.next = addTwoNumbers(l1.next, l2.next);
            return currentNode;
        }
    }
}