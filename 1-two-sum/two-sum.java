
// class Solution { //map based appraoch 
//     public int[] twoSum(int[] nums, int target) {

//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < nums.length; i++) {

//             int ans = target - nums[i];

//             if (map.containsKey(ans)) {
//                 return new int[]{map.get(ans), i};
//             }

//             map.put(nums[i], i);
//         }

//         return new int[]{};
//     }
// }
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int left=0;
        int right=n-1;
        while(left<right){
            int sum=arr[left][0]+arr[right][0];
            if(sum==target){
                return new int[]{arr[left][1],arr[right][1]}; //return pos

            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{};


    }
}