class Solution {
    public int maxScore(int[] cardPoints, int k) {//TC is O(2K) and O(1) is SC
        int leftSum=0;
        int rightSum=0;
        int maxSum=0;
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
            maxSum=leftSum; //initally maxsum is equal to left sum
        }
        int rightIdx=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[rightIdx];
            rightIdx--;
            maxSum=Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
}