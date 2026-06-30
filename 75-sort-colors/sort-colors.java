class Solution {
    public void swap(int nums[],int n1,int n2){
    int t=nums[n1];
    nums[n1]=nums[n2];
    nums[n2]=t;
}
    public void sortColors(int[] nums) {
      /* int n=nums.length;
       int c0=0,c1=0,c2=0;
       for(int i=0;i<n;i++){
        if(nums[i]==0){
            c0++;
       }else if(nums[i]==1){
        c1++;
       }else{
        c2++;
       }
    }
    int idx=0;
    for(int i=0;i<c0;i++){
      nums[idx++]=0;
    }
     for(int i=0;i<c1;i++){
      nums[idx++]=1;
    }
     for(int i=0;i<c2;i++){
      nums[idx++]=2;
    }
}
}*/
   int n=nums.length;
   int mid=0,low=0,high=n-1;
   while(mid<=high){
    if(nums[mid]==0){//0 case
      swap(nums,low,mid);
        mid++;
        low++;
    }else if(nums[mid]==1){//1
        mid++;
    }else{
         swap(nums,high,mid);
        high--;

    }
   }
    }
}
