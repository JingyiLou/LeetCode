package Top100;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                dummy.next = new ListNode(l1.val);
                dummy = dummy.next;
                l1 = l1.next;
            }else{
                dummy.next = new ListNode(l2.val);
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        if(l1==null && l2!= null) {
            dummy.next = l2;
        }else if(l1!=null && l2==null){
            dummy.next = l1;
        }
        return head.next;
    }
}
