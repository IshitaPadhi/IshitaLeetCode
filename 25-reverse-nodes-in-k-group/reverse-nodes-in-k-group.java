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
    //SC-O(1) AND TC-O(2N)FOR REVERSING AND FINDING KTH NODE RESPECTIVELY
    public ListNode reverseLinkedList(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev; //pointer reverse
            prev=temp; //bring prev to the current pos
            temp=front;//move temp to the next node
        }
        return prev;
    }
    public ListNode getKthNode(ListNode temp,int k){
        k--;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevLast=null;
        while(temp!=null){
            ListNode kthNode=getKthNode(temp,k);
            if(kthNode==null){//last me utne elements bache hi nahi ya fir there is no one
            if(prevLast!=null){
                prevLast.next=temp;
                break;
            }
            }
            //we will store the nextNode
            ListNode nextNode=kthNode.next; //store it before we point kth node's next to null
            kthNode.next=null;
            reverseLinkedList(temp);
            if(temp==head){//if it is the first node(1st kth group only then)
            head=kthNode;
            }else{
                prevLast.next=kthNode;
            }
            prevLast=temp;//remember the last node
            temp=nextNode; //go the the next node so that we start it for the next kth group

            
        }
        return head;
    }
}