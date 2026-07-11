//brute force
/*class Solution {//TC and SC both O(n^2)
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int ans[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans[j][n-i-1]=matrix[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=ans[i][j];//copy back into the same matrix
            }
        }
    }
}*/
//optimal approach- (Transpose+reverse)
class Solution{
    public void swap(int matrix[][],int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    public void reverse(int row[]){
        int left=0;
        int right=row.length-1;
        while(left<right){
        int temp=row[left];
        row[left]=row[right];
        row[right]=temp;
        left++;
        right--;
        }
    }
  public void rotate(int[][] matrix){
    int n=matrix.length;
     // Step 1: Matrix ko transpose karo
    // Row aur column interchange ho jayenge
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            swap(matrix,i,j);
        }
    }
    //then we will reverse the row 
    for(int i=0;i<n;i++){
        reverse(matrix[i]);
    }
  }
}