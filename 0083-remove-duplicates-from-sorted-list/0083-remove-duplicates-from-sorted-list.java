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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        
        Queue<ListNode> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            ListNode current = queue.poll();
            ListNode next = setNext(current);
            if (next == null) {
                current.next = null;
            } else {
                queue.offer(next);
            }
        }

        return head;
    }

    private ListNode setNext(ListNode current) {
        ListNode next = current.next;
        while (next != null) {
            if (current.val != next.val) {
                current.next = next;
                break;
            } else {
                next = next.next;
            }
        }
        return next;
    }
}