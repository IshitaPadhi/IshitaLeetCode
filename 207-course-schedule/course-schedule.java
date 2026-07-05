class Solution {
    public boolean detectCycleUtil(List<Integer> []graph ,boolean vis[],
    int curr,boolean stack[]){
        vis[curr]=true;  // Current node ko visit mark kar diya
        stack[curr]=true; // Current node recursion stack me bhi aa gaya
        // Current node ke saare neighbours check karo
        for(int neighbour:graph[curr]){
              // Agar neighbour current recursion path me already hai
            // Matlab cycle mil gayi
            if(stack[neighbour]){
                return true;
            }
              if(!vis[neighbour]){
                // DFS call lagao
                if(detectCycleUtil(graph, vis, neighbour,stack)){
                    return true;
              }
        }
     
    }
          // DFS complete ho gaya
        // Current node recursion stack se bahar aa gaya
        stack[curr]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Adjacency List banao
        List<Integer>graph[]=new ArrayList[numCourses];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // Prerequisites ko graph me convert karo
        for(int pre[] : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            //prereq->course
            graph[prereq].add(course);
        }
        boolean vis[] = new boolean[numCourses];
        boolean stack[] = new boolean[numCourses];
         // Har component me cycle detect karo
         for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if (detectCycleUtil(graph,vis,i,stack)){
                    return false ; //cycle mili hain

                }
            }
         }
    // Koi cycle nahi mili
        return true;
  
    }
}
/* USING BFS 
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Adjacency List banao
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        // Har node ki indegree store karenge
        int indegree[] = new int[numCourses];

        // Graph banao aur indegree calculate karo
        for(int[] pre : prerequisites){

            int course = pre[0];
            int prereq = pre[1];

            // prereq -> course
            graph[prereq].add(course);

            // Course ke ek prerequisite badh gaya
            indegree[course]++;
        }

        // BFS Queue
        Queue<Integer> q = new LinkedList<>();

        // Jin courses ki indegree 0 hai
        // Matlab unke koi prerequisites nahi hai
        // Unhe queue me daal do
        for(int i=0;i<numCourses;i++){

            if(indegree[i]==0){
                q.add(i);
            }
        }

        // Kitne courses successfully complete hue
        int count = 0;

        while(!q.isEmpty()){

            // Queue ke front se node nikalo
            int curr = q.remove();

            // Ek course complete ho gaya
            count++;

            // Current course ke saare neighbours check karo
            for(int neighbour : graph[curr]){

                // Current course complete hone ki wajah se
                // Neighbour ka ek prerequisite kam ho gaya
                indegree[neighbour]--;

                // Agar ab uski indegree 0 ho gayi
                // Matlab ab uske saare prerequisites complete ho gaye
                if(indegree[neighbour]==0){

                    q.add(neighbour);
                }
            }
        }

        // Agar saare courses process ho gaye
        // Matlab cycle nahi hai
        if(count==numCourses){
            return true;
        }

        // Kuch courses kabhi queue me aaye hi nahi
        // Matlab cycle hai
        return false;
    }
} */
