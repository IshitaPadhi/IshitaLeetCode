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
// APPROACH -2 HASHSET 
// class Solution{ //TC - o(n^2)
// //SC - > O(n)
//     public List<List<Integer>> threeSum(int[] nums){
//         Set<List<Integer>>set=new HashSet<>();
//         for(int i=0;i<nums.length;i++){
//              //to store prev elements
//             Set<Integer> hashSet=new HashSet<>();
//             for(int j=i+1;j<nums.length;j++){
//                 int third=-(nums[i]+nums[j]); //third el to compute sum to zero
//                 if(hashSet.contains(third)){//if present amongst prev els
//                 List<Integer>temp=Arrays.asList(nums[i],nums[j],third);
//                 Collections.sort(temp);
//                 set.add(temp); //will remove duplicates

//                 }
//                 hashSet.add(nums[j]); //to save current number for //future
//             }
           
//         }
//         return new ArrayList<>(set);
//     }
// }

//approach 3
//two pointer approach
class Solution{
     public List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>>set=new HashSet<>();
         Arrays.sort(nums); 
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //next 2 pointers
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    //we need to go ahead to take a bigger number
                    j++;

                }else if(sum>0){
                    //we need to go back to take a smaller number
                    k--;
                }else{
                    //we found the number completely adding upto zero
                    List<Integer>temp=Arrays.asList(nums[i],nums[j],nums[k]);
                    set.add(temp);
                    while(j<k && nums[j]==nums[j+1]){
                        j++; //skipping j=duplicate j's
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        k--; //skipping duplicate k's
                    }
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
     }
}