/*Definition for singly Linked List
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
*/
// class Solution {
//     //TC ANALYSIS 
//     // WE ARE USING 2 WHILE LOOPS (N*M) AND THEN  WE ARE SORTING IT SO IT TAKES XLOGX TIME WHERE X IS THE ELMENTS (N*m) AGAIN DURING CONVERSION WE ARE ACCESSING ALL ELEMENTS IN THE ARRAY SO IT IS M*N 
//     //SC ANALYSIS
//     //2(M*N) WHERE EK TOH WE ARE STORING IN ARRAY AND THEN IN LL 
//     static ListNode convert(ArrayList<Integer>arr){//STEP 1: ArrayList ko sorted linked me //convert karna
//         int n=arr.size();
//         if(n==0){
//             return null;
//         }
//         ListNode head=new ListNode(arr.get(0)); //we will make first element head
//         ListNode temp=head; //current element will point head
//         //making nodes of remaining elements
//         for(int i=1;i<n;i++){
//             ListNode newNode = new ListNode(arr.get(i));
//             temp.child=newNode; //make current node's child newNode
//             temp=temp.child;
//         }
//         return head;

//     }
//     public ListNode flattenLinkedList(ListNode head) {
//         ArrayList<Integer> arr=new ArrayList<>();
//         ListNode temp=head;
//         while(temp!=null){
//             ListNode t2=temp;// t2 current node ki child list ko traverse karega
//             while(t2!=null){
//                 arr.add(t2.val);
//                 t2=t2.child;
//             }
//             temp=temp.next;


//         }
//         Collections.sort(arr);
//         head=convert(arr);
//         return head;

//     }
// }
class Solution{//O(N1+N2)*N [depth (no of times merge is taking place )] IS TC and no sc
      public ListNode merge(ListNode next1,ListNode next2){
        ListNode dummyNode=new ListNode(-1);
        ListNode res=dummyNode;
        while(next1!=null && next2!=null){
            if(next1.val<next2.val){
                res.child=next1;
                res=next1;
                next1=next1.child;
            }else{
                res.child=next2;
                res=next2;
                next2=next2.child;
            }
        }
        if(next1!=null){
            res.child=next1;
        }else{
            res.child=next2;
        }
        res.next=null;
        return dummyNode.child;
      }
      public ListNode flattenLinkedList(ListNode head){
        //if LL is empty or if there is only one LL->already flattened base case hit
        if(head==null || head.next==null){
            return head;
        }
        // Pehle right wali list ko recursively flatten karo
        ListNode mergehead= flattenLinkedList(head.next);
        // // Current list + flattened next list ko merge karo
        head=merge(mergehead,head);
        return head;
      }

}
