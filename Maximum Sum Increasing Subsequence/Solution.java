class Solution {
    public int maxSumIncreasingSubsequence(int[] arr, int n) {
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=arr[i];//initally har element khudka hi inc subseq hi
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);// 1. Sirf current element lo (already dp[i] me hai)
                    // 2. Previous increasing subsequence me current element add karo
                }
            }
        }
          int ans=dp[0];
        for(int i=1;i<n;i++){
     // Answer kisi bhi index pe end ho sakta hai
        ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
