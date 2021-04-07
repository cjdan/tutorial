package Leetcode;

import java.util.HashSet;
import java.util.Set;


public class Solution13 {
    public static void main(String[] args) {

    }
}

class Solution15 {

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode temp = head;
        ListNode result = head;

        Set<Integer> set = new HashSet<Integer>();
        while(temp!=null){
            if(set.contains(temp.val)){
                temp = temp.next;
            }else{
                set.add(temp.val);
                temp = temp.next;
                result.next = temp;
                result = result.next;
            }
        }
        return result;

    }
}
