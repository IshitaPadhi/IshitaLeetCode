// class Solution { //brute fprce 
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>>set=new HashSet<>();
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 for(int k=j+1;k<nums.length;k++){
//                     if(nums[i]+nums[j]+nums[k]==0){
//                         List<Integer>temp=Arrays.asList(nums[i],nums[j],nums[k]);
//                         Collections.sort(temp);
//                         set.add(temp);
//                     }

//                 }
//             }

//         }
//         return new ArrayList<>(set);
//     }
// }
class Solution{
    public List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
             //to store prev elements
            Set<Integer> hashSet=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int third=-(nums[i]+nums[j]); //third el to compute sum to zero
                if(hashSet.contains(third)){//if present amongst prev els
                List<Integer>temp=Arrays.asList(nums[i],nums[j],third);
                Collections.sort(temp);
                set.add(temp); //will remove duplicates

                }
                hashSet.add(nums[j]); //to save current number for //future
            }
           
        }
        return new ArrayList<>(set);
    }
}