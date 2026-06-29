class Solution {//O(n)
    public void rev(int nums[],int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void swap(int nums[],int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        //first we will find the break point where arr[i]<arr[i+1];
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        //if we did not find the break pt->array in dec order(last permutation) so just reverse the array to get the first permutation
        if(idx==-1){
            rev(nums,0,n-1);
            return;
        }
        //swapping with what is after  break point's smallest element from the right that is bigger than arr[idx]
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[idx]){
                swap(nums,i,idx);
                break;
            }
        }
        //now after the breakpoint all elements are in dec order ->make it inc order
        rev(nums,idx+1,n-1);
    }
}