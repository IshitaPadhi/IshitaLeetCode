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
// class Solution {
//     //TC->O(N+N/2)and sc->O(1)
//     public ListNode middleNode(ListNode head) {
//         ListNode temp=head;
//         int count=0;
//         while(temp!=null){
//             count++;
//             temp=temp.next;
//         }
//         double midNode=(count/2)+1;
//         temp=head;
//         while(temp!=null){
//             midNode=midNode-1;
//             if(midNode==0){
//                 break;
//             }
//             temp=temp.next;
//         }
//         return temp;

//     }
// }
class Solution{
    //O(n/2)->TC
    //O(1)->SC
     public ListNode middleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
     }
}