/*class Solution {//burte force TC-O(n+m)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=0;
        int right=0;
        int nums3[]=new int[n+m];
        int index=0;
        while(left<m && right<n){
            if(nums1[left]<=nums2[right]){
                nums3[index++]=nums1[left++];
            }else{
                nums3[index++]=nums2[right++];
            }
        }
        while(left<m){ //while we are left with elements in the left
            nums3[index++]=nums1[left++];
        }
        while(right<n){
          nums3[index++]=nums2[right++];   
        }
        for(int i=0;i<n+m;i++){
            nums1[i]=nums3[i];
          
        }

    }
}*/
class Solution{
    public void swap(int nums1[],int nums2[],int i, int j){
        int temp=nums1[i];
        nums1[i]=nums2[j];
        nums2[j]=temp;
    }
     public void merge(int[] nums1, int m, int[] nums2, int n){
        int left=m-1; //starts from last valid element se start
        int right=0;
         // agar nums1 ka bada element nums2 ke chote element se bada hai
        // toh swap kar do
        while(left>=0 && right<n){
            if(nums1[left]>nums2[right]){
                swap(nums1,nums2,left,right);
                left--;
                right++;
            }else{
                   // arrays already correct position me hain
                // aage aur swap ki zarurat nahi
                break;
            }
        }
        //we'll sort both the arrays
        Arrays.sort(nums1,0,m);//sirf valid m elements sort honge
        Arrays.sort(nums2);

        // nums2 ke saare elements nums1 ke end me copy kar do
        for(int i=0;i<n;i++){
            nums1[i+m]=nums2[i];
        }

     }
}