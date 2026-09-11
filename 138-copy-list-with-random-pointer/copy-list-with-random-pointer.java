/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// class Solution {
//     public Node copyRandomList(Node head) {
//         Node temp=head;
//         //TC-O(2N) AND SC->(2N) N FOR HASHMAP AND N FOR 
//         HashMap<Node,Node>map=new HashMap<>();
//         while(temp!=null){
//             Node newNode =new Node(temp.val);
//             map.put(temp,newNode);
//             temp=temp.next;
//         }
//         temp=head;
//         while(temp!=null){
//             Node copyNode=map.get(temp);
//             copyNode.next=map.get(temp.next);
//             copyNode.random=map.get(temp.random);
//             temp=temp.next;
//         }
//         return map.get(head);
//     }
// }
class Solution{//TC IS O(3N) 3 PARTS OF QUES WHERE WE ARE TRAVERING THE LIST 3 TIMES AND SC IS O(N) CANNOT OMIT THE SPACE COMPLEXITY AS WE NEED EXTRA SPACE FOR THE COPY NODES- THE QUES DEMANDS US TO DO SO
    //step 1:making copy nodes
    public Node copyRandomList(Node head){
        Node temp=head;
        while(temp!=null){
            Node copyNode=new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=temp.next.next;
        }
        //step 2 is temp random pointers and copy random pointers
        temp=head;
        while(temp!=null){
           Node copyNode=temp.next;
            if(temp.random!=null){
            copyNode.random=temp.random.next;
            }else{
                copyNode.random=null;
            } //copy node of temp's random pointer
            temp=temp.next.next;
        }
        //step 3:connecting the next pointer
        Node dummyNode=new Node(-1);
        Node res=dummyNode;
        temp=head;
        while(temp!=null){
            res.next=temp.next; //straighaway point to dummy node
            temp.next=temp.next.next ; //don't point to the middle point to the actual next node
            res=res.next;
            temp=temp.next;
        }
        return dummyNode.next;
    }
}