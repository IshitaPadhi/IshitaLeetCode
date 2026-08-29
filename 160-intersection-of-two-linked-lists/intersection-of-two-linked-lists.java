/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //APPROACH 1-HASHMAP(BRUTE FORCE-EXTRA SPACE)
// public class Solution { //TC-O(N+M),SC-O(n1) in java
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashMap<ListNode,Integer>mpp=new HashMap<>();
//         ListNode temp=headA;
//         while(temp!=null){
//             mpp.put(temp,1);
//             temp=temp.next;
//         }
//         temp=headB;
//         while(temp!=null){
//             if(mpp.containsKey(temp)){
//                 return temp;
//             }
//           temp = temp.next;
//         }
//         return null;
//     }
// }

//APPROACH 2- BETTER(NO SPACE COMPLEXITY )
// TC: O(n1 + 2n2), SC: O(1)

// public class Solution {

//     // Move t2 ahead by d nodes
//     public ListNode CollisionPoint(ListNode t1, ListNode t2, int d) {

//         while (d != 0) {
//             d--;
//             t2 = t2.next;
//         }

//         // Move both together until they meet
//         while (t1 != t2) {
//             t1 = t1.next;
//             t2 = t2.next;
//         }

//         return t1;
//     }

//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//         // Find length of first list
//         ListNode temp1 = headA;
//         int n1 = 0;

//         while (temp1 != null) {
//             n1++;
//             temp1 = temp1.next;
//         }

//         // Find length of second list
//         ListNode temp2 = headB;
//         int n2 = 0;

//         while (temp2 != null) {
//             n2++;
//             temp2 = temp2.next;
//         }

//         // Move longer list ahead by length difference
//         if (n1 < n2) {
//             return CollisionPoint(headA, headB, n2 - n1);
//         } else {
//             return CollisionPoint(headB, headA, n1 - n2);
//         }
//     }
// }
//OPTIMAL APPRAOCH
//TC -O(N1+N2)and SC is O(1)
public class Solution{
 public ListNode getIntersectionNode(ListNode headA, ListNode headB){
    while(headA==null || headB==null)return null;
    ListNode t1=headA;
    ListNode t2=headB;
    while(t1!=t2){//if it is same linkedlist 
        //the outer while loop checks for the first node if they are not equal 
        t1=t1.next;
        t2=t2.next;
        if(t1==t2)return t1; //intersection found 
        if(t1==null)t1=headB;
        if(t2==null)t2=headA;

    }
    return t1;//we will return t1 if it is same LL
 }
}