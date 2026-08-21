// class Solution { //O(n^3)
//     public int subarraysWithXorK(int[] nums, int k) {
//      int count=0;
//       for(int i=0;i<nums.length;i++){
//         for(int j=i;j<nums.length;j++){
//             int xor=0;
//             for(int x=i;x<=j;k++){
//                 xor=xor^nums[x];
//             }
//             if(xor==k){
//             count++;
//             }
//         }
//       }
//       return count;
//     }
// }
// class Solution{
//     public int subarraysWithXorK(int[] nums, int k){
//         int count=0;
//         for(int i=0;i<nums.length;i++){
//             int xor=0;
//             for(int j=i;j<nums.length;i++){
//                 xor=xor^nums[j];

//             }
//             if(xor==k){
//                 count++;
//             }
//         }
//         return count;
//     }
// }
class Solution{
  //TC = O(n)
//SC = O(n)
    public int subarraysWithXorK(int[] nums, int k){
        int xr=0; // Current prefix XOR
        int cnt=0;  // Answer: kitne subarrays mile
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            xr=xr^nums[i];
                      // Hume chahiye:
            // prefixXOR ^ previousXOR = k
            // => previousXOR = prefixXOR ^ k
             int x = xr ^ k;
               // Agar x pehle mila hai, utne subarrays ka XOR k hoga
            if(map.containsKey(x)){
                cnt+=map.get(x);
            }
            map.put(xr,map.getOrDefault(xr,0)+1);


        }
        return cnt;
    }
}
