class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n=energy.length;
        int dp[]=new int[n];
        int ans=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            int sum=energy[i];
            if(i+k<n){
                sum+=dp[i+k];
            }
            dp[i]=sum;
            ans=Math.max(ans,dp[i]);
        }
     return ans;
    }
}