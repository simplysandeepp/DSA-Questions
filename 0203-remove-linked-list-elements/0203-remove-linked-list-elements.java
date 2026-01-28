class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode l = new ListNode(0);
        l.next = head;
        ListNode prev = l;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr; 
            }
            curr = curr.next;
        }
        return l.next;
    }
}
