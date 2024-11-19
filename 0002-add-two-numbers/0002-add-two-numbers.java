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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode current = null;
        while(l1 != null || l2 != null) {
            int i = 0;
            int j = 0;

            if (l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }

            int sum = i + j + carry;
            carry = sum > 9 ? 1 : 0;

            if(head == null) {
                head = new ListNode(sum % 10);
                current = head;
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
        }

        if(carry == 1) {
            current.next = new ListNode(carry);
        }
        return head;
    }
}