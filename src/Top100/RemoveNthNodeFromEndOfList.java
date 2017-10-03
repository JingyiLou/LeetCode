package Top100;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode newList = head;
        int count = 0;
        boolean isDelete = false;
        while(count<n){
            curr = curr.next;
            if(curr == null){
                newList = newList.next;
                head = head.next;
                isDelete = true;
                break;
            }
            count++;
        }
        while(!isDelete){
            if(curr.next == null){
                newList.next = newList.next.next;
                isDelete = true;
            }else{
                curr = curr.next;
                newList = newList.next;
            }
        }
        return head;
    }
}
