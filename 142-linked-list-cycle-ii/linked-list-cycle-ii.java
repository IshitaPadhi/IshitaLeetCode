/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {//TC- O(n) and SC-O(n)
//     public ListNode detectCycle(ListNode head) {
//         HashMap<ListNode,Integer>map=new HashMap<>();
//         ListNode temp=head;
//         while(temp!=null){
//             if(map.containsKey(temp)){
//                 return temp;
//             }
//             map.put(temp,1);
//             temp=temp.next;
//         }
//         return null;
//     }
// }
public class Solution{
     public ListNode detectCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head; //we will place slow at head again
                while(slow!=fast){
                    slow=slow.next; //we will move both ptrs by 1
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
     }
}