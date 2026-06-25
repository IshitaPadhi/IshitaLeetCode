/*class Solution {//bruteforce 1- O((n × m) × (n + m))
    public void markRow(int matrix[][],int row){
        int m=matrix[0].length;
        for(int j=0;j<m;j++){
            if(matrix[row][j]!=0){
                matrix[row][j]=-1;
            }
        }
    }
        public void markCol(int matrix[][],int col){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            if(matrix[i][col]!=0){
                matrix[i][col]=-1;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markRow(matrix,i);
                    markCol(matrix,j);
       
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}*/


/*class Solution{//bruteforce-2 Time: O(m × n)
Space: O(m + n)

public void setZeroes(int[][] matrix){
    int m=matrix.length;
    int n=matrix[0].length;
    int row[]=new int[m];
    int col[]=new int[n];
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==0){
                row[i]=1;
                col[j]=1;
            }
        }
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(row[i]==1||col[j]==1){
                matrix[i][j]=0;
            }
        }
    }

}

}*/

class Solution{
    public void setZeroes(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        int col0=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    //mark row 
                    matrix[i][0]=0;
                    if(j!=0){//mark for col if and only if it is not 0, 
                        matrix[0][j]=0;
                    }else{
                        col0=0;
                    }
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]!=0){
                    //check for row and col
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }

    }
    
}