// class Solution { //O(n^2)
//     public boolean linearSearch(int nums[],int x){
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==x){
//                 return true;
//             }
//         }
//         return false;
//     }
//     public int longestConsecutive(int[] nums) {
//         int longest=0;
//         for(int i=0;i<nums.length;i++){
//             int x=nums[i];
//             int count=1;
//             while(linearSearch(nums,x+1)==true){
//                 x=x+1;
//                 count=count+1;
//             }
//             longest=Math.max(count,longest);

//         }
//         return longest;

//     }
// }
class Solution{
    public int longestConsecutive(int nums[]){
        int longest=0;
        int cntcurr=0;
        int lastSmaller=Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==lastSmaller){
                cntcurr=cntcurr+1;
                lastSmaller=nums[i];
            }
            else if(nums[i]!=lastSmaller){
                //we won't do anything we will continue
                cntcurr=1; //counter reset
                lastSmaller=nums[i];

            }
            longest=Math.max(cntcurr,longest);
        }
        return longest;

    }
}