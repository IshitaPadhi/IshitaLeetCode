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
// class Solution { //BRUTE FORCE O(m+n) is Tc and so is SC
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode dummy=new ListNode(-1);
//         ListNode temp=dummy;
//         while(list1!=null && list2!=null){
//             if(list1.val<=list2.val){
//                 temp.next=new ListNode(list1.val);
//                 list1=list1.next;
//             }else{
//                 temp.next=new ListNode(list2.val);
//                 list2=list2.next;
//             }
//             temp=temp.next;
//         }
//         while(list1!=null){
//             temp.next=new ListNode(list1.val);
//             list1=list1.next;
//             temp=temp.next;
//         }
//         while(list2!=null){
//             temp.next=new ListNode(list2.val);
//             list2=list2.next;
//             temp=temp.next;
//         }
//         return dummy.next;
//     }
// }
class Solution{//TC is O(m+n) but SC is O(1)
     public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1==null)return list2;
        if(list2==null)return list1;

        // list1 ka first node bada hai,
        // toh dono lists ko swap kar do
        // taaki list1 hamesha smaller node se start ho
        if(list1.val>list2.val){
            //swap l1 and l2
            ListNode  swap=list1;
            list1=list2;
            list2=swap;
        }
        ListNode res=list1; //result first points to l1
        while(list1!=null && list2!=null){
            ListNode temp=null;
            // list1 se saare smaller/equal nodes ko process karo
            while(list1!=null && list1.val<=list2.val){
                temp=list1;
                list1=list1.next;           
             }
                // Ab list1 ke baad list2 ko connect karo
              temp.next=list2;
               //swap l1 and l2
                 // taaki next round mein list1 smaller side ho
            ListNode swap=list1;
            list1=list2;
            list2=swap;
        }
       return res;
     }
}