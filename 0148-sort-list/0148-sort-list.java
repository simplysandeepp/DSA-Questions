class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode t = null;
        while (fast != null && fast.next != null) {
            t = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        t.next = null;
        ListNode s1 = sortList(head);
        ListNode s2 = sortList(slow);
        return merge(s1,s2);
    }
    ListNode merge(ListNode s1, ListNode s2) {
        ListNode k1 = new ListNode(0);
        ListNode k2 = k1;
        while (s1 != null && s2 != null) {
            if (s1.val < s2.val) {
                k2.next = s1;
                s1 = s1.next;
            }
            else{
                k2.next = s2;
                s2 = s2.next;
            }
            k2 = k2.next;
        }
        if (s1 != null)
            k2.next = s1;
        if (s2 != null)
            k2.next = s2;
        return k1.next;
    }
}