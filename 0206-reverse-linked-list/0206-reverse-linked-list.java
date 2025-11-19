class Solution {
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head; // yaha par we r making the node link to opp. initially 4 -> 5 but ab 4 <- 5 
        head.next = null; // prev link break kar rhe hai null connect krke
        return newNode;
    }
    
}