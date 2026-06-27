class Solution {
    public boolean isSubsetSum(int[] arr, int target) {
        int n=arr.length;
       boolean dp[][]=new boolean[n+1][target+1];
       for(int i=0;i<n+1;i++){
        dp[i][0]=true;
       }
       for(int i=1;i<n+1;i++){
        for(int j=1;j<target+1;j++){
            if(arr[i-1]<=j){
                dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];//lnclusion/exclusion
                //choice

            }else {//exclusion
                dp[i][j]=dp[i-1][j];
            }
        }
       }
       return dp[n][target];

    }
}
