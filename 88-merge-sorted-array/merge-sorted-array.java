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
/*class Solution{
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
}*/
/*1. Swap + Sort Approach (ye wala code)
Swap loop: O(min(m, n))
Arrays.sort(nums1, 0, m) → O(m log m)
Arrays.sort(nums2) → O(n log n)
Copy back → O(n)

Overall TC:

O(m log m + n log n)

(Ye dominate karta hai, swap aur copy ignore ho jaate hain.)

SC: O(1)*/ //-> approach 1 
/*2. Gap Method

Har pass me poore array ko traverse karte hain → O(m+n)

Gap approximately half hota rehta hai:

len → len/2 → len/4 → ... → 1

Total passes = log(m+n)

Overall TC:

O((m+n) log(m+n))*/ //GAP METHOD -> APPROACH 2


class Solution{
    public void swapIfGreater(int nums1[],int ind1,int ind2){
        if(nums1[ind1]>nums1[ind2]){
            int temp=nums1[ind1];
            nums1[ind1]=nums1[ind2];
            nums1[ind2]=temp;
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n){
         // pehle nums2 ke elements nums1 ke end me copy kar do
         for(int i=0;i<n;i++){
            nums1[i+m]=nums2[i];
         }
         int len=m+n;
          // initial gap = ceil(len/2)
         int gap=(len/2)+(len%2);
         while(gap>0){
            int left=0;
            int right=left+gap;
              // gap maintain karte hue compare karte jao
              while(right<len){
                  // agar left wala bada hai toh swap kar do
                  swapIfGreater(nums1,left,right);
                  left++;
                  right++;
              }
              if(gap==1)break;
            gap = (gap / 2) + (gap % 2);
         }

    }
}
