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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt=0; 
        ListNode temp=head;
        //we will compute the length of the LL
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }//if from the end we want to delete the nth node
        //that is the head node
        if(cnt==n){
            ListNode newHead=head.next;
            return newHead;
        }
        //from the start it will be cnt-n+1 but we want to go to
        //it's prev so it will be cnt-n
        int res=cnt-n;
        ListNode temp1=head;
        while(temp1!=null){
            res--; //we will keep a counter till we reach the prev of delNode
            if(res==0){
                break;
            }
            temp1=temp1.next;
        }
        ListNode delNode=temp1.next;
        temp1.next=temp1.next.next;
        return head;

        
    }
}