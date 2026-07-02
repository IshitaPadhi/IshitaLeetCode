import java.util.*;

class Solution {
    public void DFSUtil(int curr,List<List<Integer>> adj,boolean vis[],
    List<Integer>ans){
        //currr ko visit kr denge
        vis[curr]=true;
        //ans me curr ko add kardenge
        ans.add(curr);
        //curr node ke saare neighbours par jao
        for(int neighbour : adj.get(curr)){
            //agar neighbour pehle se visit nahi hua hain
            if(!vis[neighbour]){
                //recursively we'll call dfs
                DFSUtil(neighbour,adj,vis,ans);
            }
        }
    }
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
       List<List<Integer>>adj=new ArrayList<>();
       //har vertex ke liye ek empty ArrayList banayenge to create ajacency List
       for(int i=0;i<V;i++){
        adj.add(new ArrayList<>());
       }
       //edge list(given) ko adjacency list me convert kardenge
       for(List<Integer>edge : edges){
        int u=edge.get(0);
        int v=edge.get(1);
        //u and v se hum first aur second ko extract kar lenge to map adjacencies
        adj.get(u).add(v); //u ke posn me v ko as neighbour add kardenge
        adj.get(v).add(u); //v ke posn me u ko as neighbour add kardenge
       }
       boolean vis[]=new boolean[V];
        List<Integer> ans = new ArrayList<>();
        DFSUtil(0,adj,vis,ans);//start with the 0th node
        return ans;
    }
    
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
    // Pehle Edge List ko Adjacency List me convert kiya
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0;i<V;i++){
        adj.add(new ArrayList<>());
    }
    for(List<Integer> edge : edges){
        int u=edge.get(0);
        int v=edge.get(1);
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    boolean vis[]=new boolean[V];
    List<Integer> ans = new ArrayList<>();
    Queue<Integer> q=new LinkedList<>();
    q.add(0);//starting node ko q me daal diya
    vis[0]=true; //vis ko bhi true mark kar diya
    while(!q.isEmpty()){
        int curr=q.remove();  // Queue ke front se node nikalo
        ans.add(curr);
        for(int neighbour : adj.get(curr)){
            if(!vis[neighbour]){//agar neighbour visit nahi hua hain 
            vis[neighbour]=true;//vis mark karo
            q.add(neighbour);
            }
          
        }
    }
    return ans;
   
    }
}

