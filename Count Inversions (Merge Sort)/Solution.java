/*class Solution {
    public long numberOfInversions(int[] nums) {
        int n=nums.length;
        long cnt=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    cnt+=1;
                }
            }
        }
        return cnt;
    }
}*/
class Solution{
    static long count =0;
     public long numberOfInversions(int[] nums){
        count=0;
        mergeSort(nums,0,nums.length-1);
        return count;
     }
     static void mergeSort(int arr[],int low,int high){
        if(low>high){
            return;//base case
        }
        int mid=low+(high-low)/2;
        //left half sort 
        mergeSort(arr,low,mid-1);
        //right half sort
        mergeSort(arr,mid+1,high);
        //merge both sorted halves
        merge(arr,low,mid,high);
     }
     static void merge(int arr[],int low,int mid,int high){
        int temp[]=new int[high-low+1];
        int left=low;
        int right=mid+1;//first element of right sorted side
        int k=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
            //no inversion in such case 
            temp[k++]=arr[left++];
            }
            else{
                //arr[left]>arr[right]
                temp[k++]=arr[right++];
                //left arr sorted hain so upgrade count to mid-left+1(left se mid tak jitne bhi hain wo bade hai)
                count+=(mid-left+1);
            }
        }
        while(left<=mid){
            temp[k++] = arr[left++];
        }
         while (right <= high) {
            temp[k++] = arr[right++];
        }
         // Original array me copy back
         for(int i=low;i<=high;i++){
            arr[i]=temp[i-low];
         }
    
     }

}
