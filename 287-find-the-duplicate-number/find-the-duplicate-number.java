// class Solution {brute force 
//     public int findDuplicate(int[] nums) {
//         int n=nums.length;
//         int freq[]=new int[n+1];
//         for(int i=0;i<n;i++){
//             freq[nums[i]]++;
//             if(freq[nums[i]]>1){
//                 return nums[i];
//             }
//         }
//         return -1;
        
//     }
// }
class Solution{
    public int findDuplicate(int[] nums){
        int fast=nums[0];
        int slow=nums[0];//initialise slow and fast pointers to the starting point
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];//move slow and fast pointers by one and 2 respectively
        }while(slow!=fast);
        fast=nums[0];
        while(fast!=slow){
            slow=nums[slow];
            fast=nums[fast];//move both by one
        }
        return slow;
    }
}