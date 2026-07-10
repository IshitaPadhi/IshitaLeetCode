class Solution {
    public boolean dfs(int graph[][],int curr,int col[]){
                for(int j=0;j<graph[curr].length;j++){
                    int neighbour=graph[curr][j];
                    if(col[neighbour]==-1){
                        int nextCol=(col[curr]==0)?1:0;
                        col[neighbour]=nextCol;
                        if(!dfs(graph,neighbour,col)){
                            return false;
                        }
                    }else if(col[neighbour]==col[curr]){
                        return false;
                    }
                }
                return true;
            
        }
        

    
    public boolean isBipartite(int[][] graph) {
        int col[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            col[i]=-1;
        }
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                col[i]=0;
               if (!dfs(graph,i,col)){
                return false;
               }
            }
        }
        return true;
    }
}

/*class Solution {//Actual BFS APPROACH 
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
        return true;
        
    }
}*/