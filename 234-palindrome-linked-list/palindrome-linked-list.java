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
// class Solution { BRUTE FORCE TC-O(2N) AND SC-O(N)

//     public boolean isPalindrome(ListNode head) {
//         Stack<Integer>st=new Stack<>();
//         ListNode temp=head;
//         while(temp!=null){
//             st.push(temp.val);
//             temp=temp.next;
//         }
//          temp=head;
//         while(temp!=null){
//         if(temp.val!=st.pop()){
//             return false;
//         }
//         temp=temp.next;
//         }
//         return true;
//     }
// }
class Solution{//TC IS O(2N) again and SC is O(1)-//Finding middle → O(N/2)
// Reversing → O(N/2)
// Comparing → O(N/2)
// Restoring → O(N/2)
    public ListNode reverseLL(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;//pointer reverse
            prev=temp; //make it the current
            temp=front; //move temp to nextNode 
        }
        return prev;
    }
     public boolean isPalindrome(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //step 2 reverseing- middle ke baad ka 
        ListNode newHead=reverseLL(slow.next);//middle ka next in case of odd elemenets in LL and usually during even middle point finding we focused on second middle point but here we are stopping at M1 and then we will go to M2 so that our second part of LL starts from there 
        ListNode first=head;
        ListNode second=newHead;
        //both pointing to their heads in resepctive halves
        while(second!=null){//until the comparisions end 
        if(first.val!=second.val){
            reverseLL(newHead); //reverse it back before returning false
            return false;

        }
        first=first.next;
        second=second.next; //keep comparing 
        }
        reverseLL(newHead);
        return true;

     }
}