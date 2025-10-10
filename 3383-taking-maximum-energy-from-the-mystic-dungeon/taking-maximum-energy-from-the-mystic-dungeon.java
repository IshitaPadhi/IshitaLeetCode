class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        // dp[i] = maximum energy you can get starting from i:
        int[] dp = new int[n];

        int answer = Integer.MIN_VALUE;

        // Process from rightmost to leftmost
        for (int i = n - 1; i >= 0; i--) {
            // Basic: take energy[i]
            int sum = energy[i];
            // If jumping is possible
            if (i + k < n) {
                sum += dp[i + k];
            }
            dp[i] = sum;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
