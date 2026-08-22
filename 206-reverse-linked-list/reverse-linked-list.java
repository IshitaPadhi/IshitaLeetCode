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
//  import java.util.*;
// class Solution { //O(2N) is TC and O(n) IS sc
//     public ListNode reverseList(ListNode head) {
//         Stack<Integer>st=new Stack<>();
//         ListNode temp=head;
//         while(temp!=null){
//             st.push(temp.val);
//             temp=temp.next; //we store elements one by one in the stack
//         }
//         temp=head; //we traverse it again
//         while(temp!=null){
//             //put the curtop stack element into the current node
//             temp.val=st.pop();
//             temp=temp.next;

//         }
//         return head;
//     }
// }
 class Solution { 
    public ListNode reverseList(ListNode head) { 

        // temp = current node ko point karega
        ListNode temp = head; 

        // Initially prev ke peeche kuch nahi hai
        // Isliye prev = null
        ListNode prev = null; 

        while (temp != null) { 

            // Pehle next node ko save kar lo
            // Kyunki abhi temp.next ko change karenge
            ListNode front = temp.next; 

            // Current node ka arrow reverse karo
            // Example: 2 -> 3
            // Ab:      2 -> 1
            temp.next = prev; 

            // prev ko current node par move karo
            prev = temp; 

            // temp ko next node par move karo
            temp = front; 
        } 

        // prev ab new head hoga
        return prev; 
    } 
}

// class Solution{ recursive 
// // TC = O(n) because every node is visited once.

// // SC = O(n) because recursion call stack can go up to n nodes.
//     public ListNode reverseList(ListNode head){
//         if(head==null || head.next==null){
//             return head;
//         }
//         ListNode newHead=reverseList(head.next);
//         ListNode front=head.next;
//         front.next=head;
//         head.next=null;
//         return newHead;
//     } 
// }