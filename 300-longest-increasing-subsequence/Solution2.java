class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        // dp[i] = Length of LIS ending at index i
        int dp[] = new int[n];

        // Initially har element khud ek LIS hai
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Har element ke liye uske pehle wale elements check karo
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // Agar increasing sequence ban sakti hai
                if (nums[j] < nums[i]) {

                    // Current LIS ko update karo
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Answer kisi bhi index pe end ho sakta hai
        int maxLength = dp[0];

        for (int i = 1; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
