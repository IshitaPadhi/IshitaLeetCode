class Solution {//O(n)->Time complexity with constant space 
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            int tempMax=Math.max(curr,Math.max(curr*max,curr*min));
            int tempMin=Math.min(curr,Math.min(curr*max,curr*min));
            max=tempMax;
            min=tempMin;
            ans=Math.max(max,ans);
        }
        return ans;
    }
}