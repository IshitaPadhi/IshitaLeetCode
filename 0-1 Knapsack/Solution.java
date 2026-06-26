class Solution {

    public int knapsack01(int[] wt, int[] val, int n, int W) {

        // dp[i][j] = maximum profit using first i items
        // with knapsack capacity j
        int dp[][] = new int[n+1][W+1];

        // Row 0 and Column 0 are already 0 in Java

        // i -> first i items
        for(int i=1;i<=n;i++){

            // j -> current knapsack capacity
            for(int j=1;j<=W;j++){

                int v = val[i-1];   // value of current item
                int w = wt[i-1];    // weight of current item

                // Current item fit ho raha hai
                if(w <= j){

                    // Include current item
                    int incProfit = v + dp[i-1][j-w];

                    // Exclude current item
                    int excProfit = dp[i-1][j];

                    // Better option choose karo
                    dp[i][j] = Math.max(incProfit, excProfit);

                }else{

                    // Fit nahi hua
                    // Sirf exclude kar sakte hain
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
}
