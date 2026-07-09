class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int islands=0;
        //pure grid ko traverse karenge
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //if you found a new land
                if(grid[i][j]=='1'){
                    islands++;//found a new island 
                    dfs(grid,i,j);//we'll visit the entire island
                }
            }
        }
        return islands;
    }
    public void dfs(char grid[][],int row,int col){
        int rows=grid.length;
        int cols=grid[0].length;
        if(row<0 || row>=rows || col<0 || col>=cols){//boundary condition
            return;
        }
        //water/already visited
        if(grid[row][col]=='0'){
            return;
        }
        //land ko visited mark kar do
        grid[row][col]='0';
        //performing dfs in all 4 directions 
        dfs(grid,row+1, col); // down
        dfs(grid,row-1,col);//up
        dfs(grid,row,col+1);//right
        dfs(grid,row,col-1);//left

    }
}