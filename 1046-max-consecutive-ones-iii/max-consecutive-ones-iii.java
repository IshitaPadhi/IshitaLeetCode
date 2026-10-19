// class Solution {BRUTE FORCE TC IS ROUGHY AROUND O(n^2) AND SC IS O(1)
//APPROACH IS TO CALCULATE ALL THE SUBARRAYS AND THEN COMPUTE THE LARGEST ONE
//     public int longestOnes(int[] nums, int k) {
//       int maxLen=0;
//       for(int i=0;i<nums.length;i++){
//         int zeroes=0;
//         for(int j=i;j<nums.length;j++){
//             if(nums[j]==0){
//                 zeroes++;
//             }
//             if(zeroes<=k){
//                 int len=j-i+1;
//                 maxLen=Math.max(len,maxLen);
//             }else{
//                 break;
//             }
//         }
//       }  
//       return maxLen;
//     }
// }
// class Solution{//BETTER APPROACH HERE THE TC IS APPROX O(2N) BECAUSE OF 2 WHILE LOOPS INTERNAL WHILE LOOP IS CAUSING AN OVERALL OF 2N TC AND O(1) SC
// //WORST CASE IS 1111100 WHERE K=1 overall 2n travel 
//     public int longestOnes(int[] nums, int k){
//         int maxLen=0;
//         int l=0;
//         int r=0;
//         int zeroes=0;
//         while(r<nums.length){
//             if (nums[r]==0)zeroes++;
//             while(zeroes>k){
//                 if(nums[l]==0)zeroes--; //shrink down the number of zeroes by sliding the left window ahead if it is zero then we increment left pointer
//                 l++;


//             }
//                 if(zeroes<=k){
//                 int len=r-l+1;
//                 maxLen=Math.max(maxLen,len);
//                 }
//                 r++;
//         } 
//         return maxLen;
//     }
// }
 class Solution{//OPTIMAL APPROACH HERE THE TC IS APPROX O(N) BECAUSE OF 1 WHILE LOOP we got rid of INTERNAL WHILE LOOP  CAUSING AN OVERALL OF 2N TC AND O(1) SC we are not directly taking the left index till the k-1th position rather we are taking it to next index but not incrementing len until we trim the zeroes till k 

    public int longestOnes(int[] nums, int k){
        int maxLen=0;
        int l=0;
       int r=0;
        int zeroes=0;
        while(r<nums.length){
            if (nums[r]==0)zeroes++;
                if(zeroes>k){
                    if(nums[l]==0){zeroes--;} //shrink down the number of zeroes by sliding the left window ahead if it is zero then we increment left pointer
                      l++;
                    
                }
                if(zeroes<=k){
                int len=r-l+1;
                maxLen=Math.max(maxLen,len);
                 }
                 r++;
      } 
       return maxLen;
    }
 }