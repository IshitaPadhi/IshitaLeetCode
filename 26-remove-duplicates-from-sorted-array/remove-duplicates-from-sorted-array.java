// class Solution {//TC-O(n) and SC-O(n)
//     public int removeDuplicates(int[] nums) {
//         Set<Integer> set=new LinkedHashSet<>();
//         for(int i=0;i<nums.length;i++){
//             set.add(nums[i]);
//         }
//         int index=0;
//         for(int x:set){
//             nums[index]=x;
//             index++;
//         }
//         return index;
//     }
// }
class Solution{//TC O(n) SC-O(1)
     public int removeDuplicates(int[] nums){
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
     }
}