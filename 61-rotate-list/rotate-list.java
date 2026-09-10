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
class Solution {//TC-O(2N) AND SC-O(1)
    public ListNode findNthNode(ListNode head,int k){
        int cnt=1;
        while(head!=null){
            if(cnt==k)return head;
            cnt++;
            head=head.next;
        }
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)return head;
        int len=1;
        ListNode tail=head;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        if(k%len==0)return head; //do nothing original LL
        k=k%len;
        
        tail.next=head;//to make it circular temporarily
        ListNode newLastNode=findNthNode(head,len-k);
        // we will go on the len-kth node and uske next node ko we will make head and we will point that node to null
        head=newLastNode.next;
        newLastNode.next=null;
        return head;

    }
}