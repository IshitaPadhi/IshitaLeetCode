class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int prefix[]=new int[n];
        prefix[0]=height[0];
        //build maxium prefix array
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],height[i]);
        }
        int rightMax=0;
        int total=0;
        for(int i=n-1;i>=0;i--){
            rightMax=Math.max(rightMax,height[i]);
            int leftMax=prefix[i];
            total+=Math.min(leftMax,rightMax)-height[i];
        }
        return total;
    }
}