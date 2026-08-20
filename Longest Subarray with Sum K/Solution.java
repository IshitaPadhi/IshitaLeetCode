// class Solution { //brute force O(n^3)

//     public int longestSubarray(int[] nums, int k) {
//         int longest=0;
//        for(int i=0;i<nums.length;i++){
//         for(int j=i;j<nums.length;j++){
//             int sum=0;
//             //inner loop to map elements from i to j
//             for(int p=i;p<=j;p++){
//                 sum+=nums[p];
//}
//                 if(sum==k){
//                     longest=Math.max(longest,j-i+1);
//                 

//             }
//         }
//        }
//        return longest;
//     }
// }
// class Solution{
//     public int longestSubarray(int[] nums, int k){
//         //O(N)-> TC AND SC->O(N)
//         // Prefix sum ko store karne ke liye HashMap
//         // Key = prefix sum
//         // Value = us prefix sum ka first index
//         HashMap<Long,Integer>preSumMap=new HashMap<>();
//         long sum=0;
//         int maxLen=0;
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];

//             // Agar starting se hi sum = K hai,
//             // toh subarray [0...i] ki length = i+1
//             if(sum==k){
//               maxLen=Math.max(maxLen,i+1);
//             }
//              // Hume check karna hai:
//             // kya pehle kabhi (sum - K) mila tha?
//             long rem=sum-k;
//             if(preSumMap.containsKey(rem)){
//             // Agar mila, toh us index ke baad se
//             // current index tak ka sum = K hoga
//             int len=i-preSumMap.get(rem);
//             maxLen=Math.max(maxLen,len);

//             }
//             // Prefix sum ko sirf FIRST TIME store karo
//             // Kyunki earliest index se subarray ki length maximum milegi
//             if(!preSumMap.containsKey(sum)){
//                 preSumMap.put(sum,i);
//             }
//         }
//         return maxLen;

//     }
// }
class Solution{//Final: TC = O(N), SC = O(1)
     public int longestSubarray(int[] nums, int k){
        int left=0;
        int right=0;
        long sum=(long)nums[0];
        int maxLen=0;
        int n=nums.length;
        while(right<n){
            while(left<=right && sum>k){
                sum-=nums[left];
                left++;
            }
            if(sum==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
            if(right<n)sum+=nums[right];
        }
        return maxLen;
     }
}
