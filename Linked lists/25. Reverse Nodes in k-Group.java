/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy; //**注意这里head回退到dummy
        while(head.next != null){
            head = reverseNextK(head, k);
        }
        return dummy.next;
    }
    
    private ListNode reverseNextK(ListNode head, int k){
        //check for length < k
        ListNode next = head;  //next is not null;
        for(int i = 0; i < k; i++){
            if(next.next == null){
                return next; 
            }
            next = next.next;
        }
        
        ListNode n1 = head.next;
        ListNode prev = head;
        ListNode cur = n1;
        for(int i = 0; i < k; i++){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        n1.next = cur;
        head.next = prev;
        return n1;
        
        
    }
}