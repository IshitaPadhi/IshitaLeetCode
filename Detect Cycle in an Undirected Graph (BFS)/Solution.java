class Solution {
    class Pair{
        int curr;
        int par;
        public Pair(int curr,int par){
            this.curr=curr;
            this.par=par;
        }
    }
    public boolean BFSdetectCycleUtil(int src,List<Integer>[] adj,boolean vis[]){
        Queue<Pair>q=new LinkedList<>();//we'll store pair objs in Queue
        q.add(new Pair(src,-1));
        //mark src as vis
        vis[src]=true;
        while(!q.isEmpty()){
            //remove front object
            Pair front=q.remove();
            int current=front.curr;
            int parent=front.par;
            for(int neighbour : adj[current]){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                       // Queue me neighbour aur current ko uska parent bana ke daalo
                    q.add(new Pair(neighbour,current));
                }else if(neighbour!=parent){
                    return true;
                }
            }
        }
        return false;
        

    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
            if(BFSdetectCycleUtil(i,adj,vis)){
                return true;
            }

            }
        }
        return false;
    }
}
