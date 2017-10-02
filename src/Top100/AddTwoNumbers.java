package Top100;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int carry = 0;
        while(l1!=null || l2!=null){
            int x = (l1 == null) ? 0: l1.val;
            int y = (l2 == null) ? 0: l2.val;
            int num = x + y + carry;
            curr.next = new ListNode(num%10);
            carry = num / 10;
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return res.next;
    }
}
