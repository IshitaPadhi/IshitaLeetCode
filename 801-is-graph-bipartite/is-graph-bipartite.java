class Solution {
    public boolean isBipartite(int[][] graph) {
        int col[]=new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i]=-1; // no colour
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){//unvisited hain toh 
                q.add(i);
                col[i]=0;//yellow
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].length;j++){
                        int neighbour=graph[curr][j];
                        if(col[neighbour]==-1){//case 1 ->no color
                        int nextCol=(col[curr]==0)?1:0;
                        col[neighbour]=nextCol;
                        q.add(neighbour);

                        }else if(col[neighbour]==col[curr]){
                            return false; // not birpartite adj walo ka same color
                        }
                    }
                }
            }
        }
        return true;//if graph doesn't have cycle->by default bypartite (extra info)
        
    }
}