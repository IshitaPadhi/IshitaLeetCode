class Solution {
    public boolean detectCycleUtil(List<Integer>[] adj,boolean vis[],int curr,
    int par){
        vis[curr]=true;
        for(int i=0;i<adj[curr].size();i++){
            int neighbour=adj[curr].get(i);
            if(!vis[neighbour]){
                if(detectCycleUtil(adj,vis,neighbour,curr)){
                    return true;
                }
            }else if(neighbour!=par){//visited and neighbour is not parent ->definitely a cycle 
                return true;
            }
        }
        return false;

    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
            if(detectCycleUtil(adj,vis,i,-1)){
                return true;
            }

            }
        }
        return false;
    }
}
