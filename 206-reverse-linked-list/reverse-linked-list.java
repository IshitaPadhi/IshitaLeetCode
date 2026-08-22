/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 import java.util.*;
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer>st=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            st.push(temp.val);
            temp=temp.next; //we store elements one by one in the stack
        }
        temp=head; //we traverse it again
        while(temp!=null){
            //put the curtop stack element into the current node
            temp.val=st.pop();
            temp=temp.next;

        }
        return head;
    }
}