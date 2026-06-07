/*A straightforward approach is to insert all k² elements into a min-heap and extract them, which gives O(k² log(k²)) time and O(k²) space. Since each row is already sorted, we can optimize by maintaining only one active element from each row in the heap, reducing the auxiliary space to O(k) while keeping the time complexity O(k² log k)."*/
//brute force- 
/*PriorityQueue<Integer> pq = new PriorityQueue<>();

for(int i = 0; i < k; i++) {
    for(int j = 0; j < k; j++) {
        pq.add(arr[i][j]);
    }
}

List<Integer> ans = new ArrayList<>();

while(!pq.isEmpty()) {
    ans.add(pq.remove());
}*/
import java.util.*;
class Solution{
static class node implements Comparable<node>{
    int val;
    int row;
    int col;
    public node(int val,int row,int col){
        this.val=val;
        this.row=row;
        this.col=col;
    }
    @Override
    public int compareTo(node v2){
        return this.val-v2.val;
    }
}
     public List<Integer> mergeKSortedArrays(int[][] arr, int k){
        PriorityQueue<node>pq=new PriorityQueue<>();
        //adding 1st element of every row 
        for(int i=0;i<k;i++){
            pq.add(new node(arr[i][0],i,0));
        }
        List<Integer>ans=new ArrayList<>();
        while(!pq.isEmpty()){//until min heap becomes empty
        node curr=pq.remove();//extract the smallest element 
        ans.add(curr.val);//put it in the ans
        if(curr.col+1<k){//put the next element from the same row 
            pq.add(new node(arr[curr.row][curr.col+1],curr.row,curr.col+1));

        }
       
     }
      return ans;
    
}
}
