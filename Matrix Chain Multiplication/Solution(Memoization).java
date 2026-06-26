class Solution {
     public int matrixMultiplication(int[] arr) {

        int n = arr.length;

        int dp[][] = new int[n][n];

        // Initialize DP with -1
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(arr, 1, n - 1, dp);
    }

    public int solve(int[] arr,int i,int j,int dp[][]) {
        //memoization
        if(i==j){//diagonal elements are 0
        return 0;
        }
        if(dp[i][j]!=-1){//agar ans stored hain toh stored anw return karo
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){//partitions
        int cost1=solve(arr,i,k,dp); // i se k
        int cost2=solve(arr,k+1,j,dp); //k+1 to j
        int cost3=arr[i-1]*arr[k]*arr[j];
        ans=Math.min(ans,cost1+cost2+cost3);



        }
        return dp[i][j]=ans;

    }
}
