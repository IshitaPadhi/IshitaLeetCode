class Solution {
    public int matrixMultiplication(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        //initialization not needed
        for(int len=2;len<=n-1;len++){ //matric len 2 se shuru hota hain 2,3,4,5...
            for(int i=1;i<=n-len;i++){ // as we go down , no of rows decrease so n-len
                int j=i+len-1; //col can be computed as i+len-1
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){ //paritioning 
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=nums[i-1]*nums[k]*nums[j]; //cost (a*b)(b*c) and cost is a*b*c 
                    dp[i][j]=Math.min(dp[i][j],cost1+cost2+cost3);
               }
            }
        }
        return dp[1][n-1];
    }
}
