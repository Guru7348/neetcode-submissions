class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode revl1 = l1;
        ListNode revl2 = l2;

        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (revl1 != null || revl2 != null || carry > 0) {

            int val1 = (revl1 != null) ? revl1.val : 0;
            int val2 = (revl2 != null) ? revl2.val : 0;

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            int digit = sum % 10;

            curr.next = new ListNode(digit);
            curr = curr.next;

            if (revl1 != null) revl1 = revl1.next;
            if (revl2 != null) revl2 = revl2.next;
        }

        return dummy.next;
    }
}