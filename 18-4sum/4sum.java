// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         long sum=0;
//         Set<List<Integer>>s=new HashSet<>();
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 for(int k=j+1;k<nums.length;k++){
//                     for(int l=k+1;l<nums.length;l++){
//                         sum=nums[i]+nums[j];
//                         sum+=nums[k];
//                         sum+=nums[l];
//                         if(sum==target){
//                             List<Integer>temp=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
//                             s.add(temp);
                            
//                         }

//                         }
//                     }
//                 }
                 
//         }
//          return new ArrayList<>(s);
            
      
// }
// }
class Solution{
     public List<List<Integer>> fourSum(int[] nums, int target){
        int n=nums.length;
            //to store quadruplets
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
            //to store (i,j) pair
                Set<Long> hashset=new HashSet<>();
                for(int k=j+1;k<nums.length;k++){
                   long sum=(long)nums[i]+nums[j]+nums[k];
                   long fourth=(long)target-sum;
                   if(hashset.contains(fourth)){
                    List<Integer> temp= Arrays.asList(
                        nums[i],nums[j],nums[k],(int) fourth
                    );
                    Collections.sort(temp);
                    st.add(temp);
                   }
                   hashset.add((long)nums[k]);

                }
            }
        }
        return new ArrayList<>(st);
     }
}