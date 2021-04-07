package Leetcode;

///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//
//
class Solution11 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        head2 = head1.next;
        head3 = head2.next;
        head4 = head3.next;
        head5 = head4.next;
        head6 = head5.next;
        head6.next=null;





    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head.next==null){
            return head;
        }
        ListNode temp = head.next;
        ListNode res = head.next;
        int length=0;
        while (true){
            if (temp.next==null){
                break;
            }else {
                length++;
                temp = temp.next;
            }

        }

        for(int i=0;i<length-k;i++){
            res = res.next;
        }
        return res;
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}