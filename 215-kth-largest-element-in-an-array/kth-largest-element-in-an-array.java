class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> n=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            n.add(nums[i]);
            if(n.size()>k){
                n.remove();
            }
        }
        return n.peek();
        
    }
}