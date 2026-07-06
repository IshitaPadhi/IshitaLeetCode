class Solution {

    public int[] topoSort(int V, List<List<Integer>> adj) {
        int ans[]=new int[V];
        int indegree[]=new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){//calc indegree
            for(int neighbour : adj.get(i)){
                indegree[neighbour]++;
            }
        }
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i); // add the vertex with inedegree 0 to the queue 
            }
        }
        int index = 0;
        while(!q.isEmpty()){//until n unless the queue is not empty
        int curr=q.remove();
        int i=0;
        ans[index++]=curr;
            for(int neighbour : adj.get(curr)){//cuur node ke neighbours ko dekhenge in adj list
                // Edge remove hone jaisa hai, isliye indegree kam karo
                indegree[neighbour]--;
            if(indegree[i]==0){
            q.add(neighbour);
        }
            }
    
        }

       
    return ans;
    
    
    }
}
