class Solution {
    public int[] prefixMax(int arr[]){
        int n=arr.length;
        int prefix[]=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],arr[i]);
        }
        return prefix;
    }
    public int[] suffixMax(int arr[]){
        int n=arr.length;
        int suffix[]=new int[n];
        suffix[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],arr[i]);
        }
        return suffix;
    }
    public int trap(int[] height) {
        int total=0;
        int n=height.length;
        int preMax[] = prefixMax(height);
        int suMax[] = suffixMax(height);
        for(int i=0;i<n;i++){
            int leftMax=preMax[i];
            int rightMax=suMax[i];
            if(height[i]<leftMax && height[i]<rightMax){
                total+=Math.min(leftMax,rightMax)-height[i];
            }
        }
        return total;
    }
}