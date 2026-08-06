// class Solution { //brute force 
//     public int reversePairs(int[] nums) {
//         int n=nums.length;
//          int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(nums[i]>2*nums[j]){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
class Solution{
    static long count=0;
    public int reversePairs(int[] nums){
        count=0;
        mergeSort(nums,0,nums.length-1);
        return (int) count;

    }
    public void mergeSort(int arr[],int low,int high){
        if(low>=high){
            return;
        }
        int mid=low+(high-low)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);

    }
    public void countPairs(int arr[],int low,int mid,int high){
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)arr[i]>2L*arr[right]){
                right++;
            }
            count+=right-(mid+1);
        }

    }
    public void merge(int arr[],int low,int mid,int high){
        int temp[]=new int[high-low+1];
        int left=low;
        int right=mid+1;
        int k=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[k++]=arr[left++];
            }else{
                temp[k++]=arr[right++];
            }
        }
        while(left<=mid){
            temp[k++]=arr[left++];
        }
        while(right<=high){
            temp[k++]=arr[right++];
        }
        for(int i=low;i<=high;i++){
            arr[i]=temp[i-low];
        }

    }
}
