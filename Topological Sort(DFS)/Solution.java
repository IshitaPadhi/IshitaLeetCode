class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int ans[]=new int[V];
        boolean vis[]=new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topoSortUtil(adj,i,vis,s);
            }
        }
        int i=0;
        while(!s.isEmpty()){
           ans[i++]=s.pop();
        }
       
    return ans;
    }
    public static void topoSortUtil(List<List<Integer>> adj,int curr,boolean vis[],Stack<Integer> s){
        vis[curr]=true;
        for(int neighbour : adj.get(curr)){
            if(!vis[neighbour]){
                topoSortUtil(adj,neighbour,vis,s);
            }
        }

        // Jab current node ke saare neighbours process ho jaye,
        // tab current node ko stack me push karo
        s.push(curr);
    }
}
