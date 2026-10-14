
// class Solution {BRUTE FORCE TC IS O(N*K)AND SC IS O(N-K+1)
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int ans[] = new int[n - k + 1];

//         for (int i = 0; i <= n - k; i++) {
//             int max = nums[i];

//             for (int j = i; j < i + k; j++) {
//                 if (nums[j] > max) {
//                     max = nums[j];
//                 }
//             }

//             ans[i] = max;
//         }

//         return ans;
//     }
class Solution {//O(N) TC AND SC APPROX 
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        Deque<Integer> dq=new LinkedList<>();
        //scan for first window
        for(int i=0;i<k;i++){
            //remove smaller elements from back
            while(dq.size()>0 && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        ans[0]=nums[dq.peekFirst()]; //store the first maximum
        //scan for the remaining windows
        for(int i=k;i<n;i++){
            //remove the index outside the window 
            while(dq.size()>0 && dq.peekFirst()<=i-k){
               dq.pollFirst();
            }
            //remove smaller elements from back
            while(dq.size()>0 && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            ans[i-k+1]=nums[dq.peekFirst()];
        }
        return ans;
    }
}