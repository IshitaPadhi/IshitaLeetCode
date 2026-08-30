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
// public class Solution {
//TC- O(n) and SC-O(n)
//     public boolean hasCycle(ListNode head) {
//         HashMap<ListNode,Integer>map=new HashMap<>();
//         ListNode temp=head;
//         while(temp!=null){
//              // If node is already present, cycle exists
//             if(map.containsKey(temp)){
//                 return true;
//             }
//             map.put(temp,1);
//             temp=temp.next;
//         }
//         return false;
//     }
// }
public class Solution{
    public boolean hasCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}