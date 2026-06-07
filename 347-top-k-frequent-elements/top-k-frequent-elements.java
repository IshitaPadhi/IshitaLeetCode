import java.util.*;
class Solution {
    class node implements Comparable<node>{
        int val;
        int freq;
        public node(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
        @Override
        public int compareTo(node v2){
           return this.freq-v2.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<node> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            pq.add(new node(key,map.get(key)));
            if(pq.size()>k){
            pq.remove();
        }
        }
        
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.remove().val;
        }
        return ans;
            
        
        
    }
}